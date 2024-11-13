package pt.iade.ei.thinktoilet.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.ui.components.LocationCard
import pt.iade.ei.thinktoilet.ui.navegation.BottomSheetNavigation
import pt.iade.ei.thinktoilet.ui.navegation.Routes
import pt.iade.ei.thinktoilet.ui.pages.ToiletPage
import pt.iade.ei.thinktoilet.viewmodels.LocalViewModel

val LocalNavHostController = compositionLocalOf<NavController> { error("NavHostController ERRO") }

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    mainNavController: NavController = rememberNavController(),
    initialSheetValue: SheetValue = SheetValue.PartiallyExpanded,
    viewModel: LocalViewModel = viewModel(),
    selectedToiletId: Int? = null,
) {
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val bottomSheetCurrentRoute =
        navController.currentBackStackEntryAsState().value?.destination?.route
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = initialSheetValue,
            confirmValueChange = {
                it == SheetValue.Expanded || it == SheetValue.PartiallyExpanded
            }
        )
    )

    LaunchedEffect(selectedToiletId) {
        if (selectedToiletId != null) {
            navController.navigate(Routes.HomeToiletDetail(selectedToiletId))
        }
    }

    LaunchedEffect(bottomSheetCurrentRoute) {
        if (bottomSheetCurrentRoute == "home/{toiletId}") {
            scaffoldState.bottomSheetState.expand()
        } else {
            scaffoldState.bottomSheetState.partialExpand()
        }
    }

    val toggleSheetState: () -> Unit = {
        scope.launch {
            if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
                scaffoldState.bottomSheetState.partialExpand()
            } else {
                scaffoldState.bottomSheetState.expand()
            }
        }
    }
    CompositionLocalProvider(
        LocalNavHostController provides navController
    ) {
        BottomSheetScaffold(
            scaffoldState = scaffoldState,
            sheetPeekHeight = 140.dp,
            sheetShadowElevation = 8.dp,
            sheetContainerColor = MaterialTheme.colorScheme.surfaceContainerLow,
            sheetDragHandle = {
                CustomDragHandle {
                    toggleSheetState()
                }
            },
            sheetContent = {
                Box(
                    modifier = Modifier.fillMaxHeight(0.99f)
                ) {
                    BottomSheetNavigation(navController, mainNavController, viewModel)
                }
            },
        ) {}
    }
}

@Composable
fun ToiletDetail(
    navController: NavController,
    viewModel: LocalViewModel = viewModel(),
    toiletId: Int,
) {
    val toilet = viewModel.getToilet(toiletId)
    LazyColumn {
        item {
            ToiletPage(toilet = toilet!!) {
                navController.navigate("rating") {
                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = false
                    }
                    launchSingleTop = true
                }
            }
        }
    }
}

@Composable
fun ToiletList(
    toilets: List<Toilet>,
    onToiletSelected: (Int) -> Unit
) {
    LazyColumn {
        items(5) { index ->
            LocationCard(
                toilet = toilets[index],
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
    height: Dp = 4.dp,
    onClick: () -> Unit = {}
) {
    Surface(
        modifier = Modifier
            .padding(vertical = verticalPadding)
            .clickable { onClick() },
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