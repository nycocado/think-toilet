package pt.iade.ei.thinktoilet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.test.generateToilet
import pt.iade.ei.thinktoilet.ui.components.LocationCard
import pt.iade.ei.thinktoilet.ui.theme.ThinkToiletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ThinkToiletTheme {
                MainView()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView() {
    ThinkToiletTheme {
        var sheetState = rememberBottomSheetScaffoldState()

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "ThinkToilet")
                    }
                )
            },
            bottomBar = {
                BottomAppBar (
                    content = {
                        Text(text = "BottomAppBar")
                    }
                )
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                BottomSheetScaffold(
                    sheetContent = {
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            items(10) {
                                LocationCard(
                                    toilet = generateToilet(),
                                    distance = "1.2 km"
                                )
                            }
                        }
                    },
                    sheetPeekHeight = 160.dp,
                    scaffoldState = sheetState
                ) {

                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}