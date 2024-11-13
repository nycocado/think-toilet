package pt.iade.ei.thinktoilet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.ui.navegation.BottomNavigationBar
import pt.iade.ei.thinktoilet.ui.navegation.Routes
import pt.iade.ei.thinktoilet.ui.screens.HistoryScreen
import pt.iade.ei.thinktoilet.ui.screens.HomeScreen
import pt.iade.ei.thinktoilet.ui.screens.ProfileScreen
import pt.iade.ei.thinktoilet.ui.screens.RatingScreen
import pt.iade.ei.thinktoilet.ui.theme.AppTheme
import pt.iade.ei.thinktoilet.viewmodels.LocalViewModel

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
    val navController = rememberNavController()
    val viewModel: LocalViewModel = viewModel()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = Routes.Home
            ) {
                homeNavScreen(navController, viewModel)
                historyNavScreen(
                    viewModel.getToilets(),
                    onNavigateToHomeScreen = { selectedToiletId ->
                        val id = selectedToiletId.toString()
                        navController.navigate(Routes.HomeToiletDetail(id)) {
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = false
                            }
                            launchSingleTop = true
                        }
                    }
                )
                profileNavScreen(navController, viewModel)
                ratingNavScreen(navController, viewModel)
                homeToiletDetailNavScreen(navController, viewModel)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun NavGraphBuilder.homeNavScreen(
    navController: NavHostController,
    viewModel: LocalViewModel
) {
    composable(Routes.Home) {
        HomeScreen(navController = navController, viewModel = viewModel)
    }
}

private fun NavGraphBuilder.historyNavScreen(
    toilets: List<Toilet> = emptyList(),
    onNavigateToHomeScreen: (Int?) -> Unit,
) {
    composable(Routes.History) {
        HistoryScreen(onNavigateToHomeScreen, toilets)
    }
}

private fun NavGraphBuilder.profileNavScreen(
    navController: NavHostController,
    viewModel: LocalViewModel
) {
    composable(Routes.Profile) {
        ProfileScreen(navController = navController, viewModel = viewModel)
    }
}

private fun NavGraphBuilder.ratingNavScreen(
    navController: NavHostController,
    viewModel: LocalViewModel
) {
    composable(Routes.Rating) {
        RatingScreen(navController = navController, viewModel = viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
private fun NavGraphBuilder.homeToiletDetailNavScreen(
    navController: NavHostController,
    viewModel: LocalViewModel
) {
    composable(Routes.HomeToiletDetail) {
        val toiletId = it.arguments?.getString("toiletId")!!.toInt()
        HomeScreen(
            navController = navController,
            viewModel = viewModel,
            selectedToiletId = toiletId
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    MainView()
}
