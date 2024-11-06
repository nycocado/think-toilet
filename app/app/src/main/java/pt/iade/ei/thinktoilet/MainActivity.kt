package pt.iade.ei.thinktoilet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pt.iade.ei.thinktoilet.ui.components.BottomSheetScaffoldThinkToilet
import pt.iade.ei.thinktoilet.ui.components.CreateNavItems
import pt.iade.ei.thinktoilet.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                MainView()
            }
        }
    }
}

@Composable
fun MainView() {
    val items = CreateNavItems()
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    AppTheme{
        Scaffold(
            bottomBar = {
                NavigationBar {
                    items.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                //navController.navigate(item.title)
                            },
                            label = { Text(text = item.title) },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        when { // esse When É um IF mas meu deu bug pedir do GPT consertar ele me deu isso
                                            item.badgeCount != null -> {
                                                Badge {
                                                    Text(text = item.badgeCount.toString())
                                                }
                                            }
                                            item.hasNews -> {
                                                Badge()
                                            }
                                        }
                                    }
                                ) {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            }
                        )
                    }
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
