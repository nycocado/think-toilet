package pt.iade.ei.thinktoilet

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.test.generateRandomDistance
import pt.iade.ei.thinktoilet.test.generateRandomToiletsWithComments
import pt.iade.ei.thinktoilet.ui.components.LocationCard
import pt.iade.ei.thinktoilet.ui.components.ToiletPage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.PartiallyExpanded,
            confirmValueChange = {
                it == SheetValue.Expanded || it == SheetValue.PartiallyExpanded
            }
        )
    )
    var locationSelected by remember { mutableStateOf(false) }
    var toiletSelected by remember { mutableStateOf<Toilet?>(null) }
    val toilets: List<Toilet> = remember {
        generateRandomToiletsWithComments(
            numToilets = 5,
            numComments = 5
        )
    }

    BackHandler(enabled = locationSelected) {
        locationSelected = false
        toiletSelected = null
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = 140.dp,
        sheetShadowElevation = 8.dp,
        sheetContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
        sheetDragHandle = {
            CustomDragHandle()
        },
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.99f)
            ) {
                if (locationSelected) {
                    LaunchedEffect(scaffoldState.bottomSheetState) {
                        scaffoldState.bottomSheetState.expand()
                    }
                    SelectedToiletContent(toiletSelected!!)
                } else {
                    LaunchedEffect(scaffoldState.bottomSheetState) {
                        scaffoldState.bottomSheetState.partialExpand()
                    }
                    ToiletListContent(toilets = toilets) { selectedToilet ->
                        locationSelected = true
                        toiletSelected = selectedToilet
                    }
                }
            }
        },
    ) {}
}

@Composable
fun SelectedToiletContent(toilet: Toilet) {
    LazyColumn {
        item {
            ToiletPage(toilet = toilet)
        }
    }
}

@Composable
fun ToiletListContent(toilets: List<Toilet>, onToiletSelected: (Toilet) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(toilets) { toilet ->
            LocationCard(
                toilet = toilet,
                distance = generateRandomDistance(),
                onClick = onToiletSelected
            )
        }
    }
}

@Composable
fun CustomDragHandle(
    verticalPadding: Dp = 14.dp,
    color: Color = MaterialTheme.colorScheme.outline,
    shape: CornerBasedShape = MaterialTheme.shapes.extraLarge,
    width: Dp = 40.dp,
    height: Dp = 4.dp
) {
    Surface(
        modifier = Modifier
            .padding(vertical = verticalPadding),
        color = color,
        shape = shape
    ) {
        Box(
            Modifier.size(
                width = width,
                height = height
            )
        )
    }
}