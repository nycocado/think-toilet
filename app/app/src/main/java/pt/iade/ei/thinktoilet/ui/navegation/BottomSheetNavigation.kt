package pt.iade.ei.thinktoilet.ui.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import pt.iade.ei.thinktoilet.ui.screens.ToiletDetail
import pt.iade.ei.thinktoilet.ui.screens.ToiletList
import pt.iade.ei.thinktoilet.viewmodels.LocalViewModel

@Composable
fun BottomSheetNavigation(
    navController: NavHostController,
    mainNavController: NavController,
    viewModel: LocalViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        toiletListNavScreen(viewModel, navController)
        toiletDetailNavScreen(mainNavController, viewModel)
    }
}

private fun NavGraphBuilder.toiletDetailNavScreen(
    mainNavController: NavController,
    viewModel: LocalViewModel
) {
    composable(Routes.HomeToiletDetail) { backStackEntry ->
        val toiletId = backStackEntry.arguments?.getString("toiletId")!!.toInt()
        ToiletDetail(
            navController = mainNavController,
            viewModel = viewModel,
            toiletId = toiletId
        )
    }
}

private fun NavGraphBuilder.toiletListNavScreen(
    viewModel: LocalViewModel,
    navController: NavHostController
) {
    composable(Routes.Home) {
        ToiletList(toilets = viewModel.getToilets()) { toiletId ->
            navController.navigate(Routes.HomeToiletDetail(toiletId))
        }
    }
}