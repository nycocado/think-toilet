package pt.iade.ei.thinktoilet.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import pt.iade.ei.thinktoilet.R
import pt.iade.ei.thinktoilet.ui.components.ProfileStatus
import pt.iade.ei.thinktoilet.ui.components.ProfileUser
import pt.iade.ei.thinktoilet.ui.components.ToiletReview
import pt.iade.ei.thinktoilet.viewmodel.LocalViewModel

@Composable
fun ProfileScreen(
    navController: NavController = rememberNavController(),
    localViewModel: LocalViewModel = viewModel()
) {
    val userMain = localViewModel.userMain.value!!
    val comments = localViewModel.commentsUser.observeAsState().value?.filter { it.userId == userMain.user.id }.orEmpty()
    val context = LocalContext.current

    if (comments.isEmpty()) {
        localViewModel.getUserComments(userMain.user.id!!)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn {
            item {
                Text(
                    modifier = Modifier.padding(vertical = 20.dp),
                    text = context.getString(R.string.profile),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineLarge
                )
            }

            item {
                ProfileUser(userMain, context)
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 15.dp
                        ),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = {
                            println("Botão de editar perfil pressionado")
                        }, colors = ButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            disabledContainerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                            disabledContentColor = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f)
                        )
                    ) {
                        Text(
                            text = context.getString(R.string.edit_profile),
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            item {
                ProfileStatus(userMain.user, context)
            }

            item {
                HorizontalDivider(
                    modifier = Modifier
                        .padding(
                            top = 30.dp,
                            bottom = 20.dp
                        )
                        .fillMaxWidth(1f),
                    thickness = 2.dp,
                    color = Color.LightGray
                )
            }

            item {
                Text(
                    text = context.getString(R.string.your_critics),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineSmall,
                    textDecoration = TextDecoration.Underline
                )
            }

            if (comments.isEmpty()) {
                item {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
            } else {
                items(comments) { comment ->
                    val toilet = localViewModel.toilets.value?.find { it.id == comment.toiletId }
                    if(toilet != null){
                        ToiletReview(
                            comment = comment,
                            toilet = toilet
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
