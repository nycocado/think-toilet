package pt.iade.ei.thinktoilet.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.models.ToiletDetailed
import pt.iade.ei.thinktoilet.tests.generateRandomToiletsDetailed
import pt.iade.ei.thinktoilet.tests.generateRandomToiletsDetailedToList
import pt.iade.ei.thinktoilet.ui.components.HistoryCard

@Composable
fun HistoryScreen(
    onNavigateToHomeScreen : (Int?) -> Unit = {},
    toiletsDetailed: List<ToiletDetailed> = emptyList()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
    ) {
        LazyColumn {
            items(toiletsDetailed) { toiletDetailed ->
                HistoryCard(
                    toilet = toiletDetailed.toilet,
                    onClick = { selectedToiletId ->
                        onNavigateToHomeScreen(selectedToiletId)
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HistoryPreview() {
    HistoryScreen(
        toiletsDetailed = generateRandomToiletsDetailedToList()
    )
}
