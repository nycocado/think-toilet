package pt.iade.ei.thinktoilet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.ui.components.BottomSheetScaffoldThinkToilet
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

@Composable
fun MainView() {
    ThinkToiletTheme {
        Scaffold(
            bottomBar = {
                BottomAppBar {
                    Text(
                        text = "BottomAppBar",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        ) { innerPadding ->
            Box(
                Modifier
                    .padding(innerPadding)
            ) {
                BottomSheetScaffoldThinkToilet()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}