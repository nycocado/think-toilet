package pt.iade.ei.thinktoilet.ui.screens

import android.location.Location
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.models.UiState
import pt.iade.ei.thinktoilet.tests.generateLocationStateFlow
import pt.iade.ei.thinktoilet.tests.generateToiletsNearbyIdsStateFlow
import pt.iade.ei.thinktoilet.tests.generateToiletsStateFlow
import pt.iade.ei.thinktoilet.ui.components.LocationCard

@Composable
fun ToiletListScreen(
    toiletsStateFlow: StateFlow<Map<Int, Toilet>>,
    toiletsNearbyIdsStateFlow: StateFlow<UiState<List<Int>>>,
    locationStateFlow: StateFlow<Location>,
    navigateToToiletDetail: (Int) -> Unit = {}
) {
    val toilets = toiletsStateFlow.collectAsState().value
    val toiletIds = toiletsNearbyIdsStateFlow.collectAsState().value

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        when (toiletIds) {
            UiState.Loading -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CircularProgressIndicator(
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            is UiState.Success -> {
                val toiletList = toiletIds.data.mapNotNull { toilets[it] }
                LazyColumn {
                    items(toiletList) { toilet ->
                        LocationCard(
                            toilet = toilet,
                            location = locationStateFlow.collectAsState().value,
                            onClick = navigateToToiletDetail
                        )
                    }
                }
            }

            is UiState.Error -> {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = toiletIds.message)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToiletListPreview() {
    val toiletsStateFlow = generateToiletsStateFlow()
    val toilets = toiletsStateFlow.collectAsState().value
    val toiletsNearbyIdsStateFlow = generateToiletsNearbyIdsStateFlow(toilets)
    val locationStateFlow = generateLocationStateFlow()
    ToiletListScreen(
        toiletsStateFlow = toiletsStateFlow,
        toiletsNearbyIdsStateFlow = toiletsNearbyIdsStateFlow,
        locationStateFlow = locationStateFlow
    )
}