package pt.iade.ei.thinktoilet.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import pt.iade.ei.thinktoilet.ui.navegation.BottomNavigationBar
import pt.iade.ei.thinktoilet.ui.navegation.MainNavigationGraph
import pt.iade.ei.thinktoilet.ui.permission.CheckAndRequestLocationPermission
import pt.iade.ei.thinktoilet.viewmodel.LocalViewModel
import pt.iade.ei.thinktoilet.viewmodel.UserViewModel

@Composable
fun MainView(
    rootController: NavController,
    localViewModel: LocalViewModel,
    userViewModel: UserViewModel,
    navController: NavHostController = rememberNavController()
) {
    val scope = rememberCoroutineScope()
    val user = userViewModel.user.collectAsState().value
    CheckAndRequestLocationPermission(
        onPermissionGranted = {
            scope.launch { localViewModel.loadLocation(true, user?.id) }
        },
        onPermissionDenied = {
            // Não vai carregar os banheiros próximos
        }
    )

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController, rootController, userViewModel.isUserLoggedIn)
        }
    ) { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
        ) {
            MainNavigationGraph(navController, rootController, localViewModel, userViewModel)
        }

    }
}