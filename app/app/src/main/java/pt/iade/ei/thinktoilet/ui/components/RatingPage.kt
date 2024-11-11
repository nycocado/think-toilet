package pt.iade.ei.thinktoilet.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.thinktoilet.R
import pt.iade.ei.thinktoilet.models.Position
import pt.iade.ei.thinktoilet.models.UserMain
import pt.iade.ei.thinktoilet.ui.theme.AppTheme

@Composable
fun RatingPage(
    user: UserMain,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Avaliar",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 32.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 20.dp)
        )
        ProfileRating(user)
        Row(
            modifier = Modifier.padding(
                top = 5.dp,
                bottom = 1.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(end = 20.dp)
                ) {
                }
            }
            Row(
                modifier = Modifier
                    .padding(end = 10.dp)

            ){

            }
        }
    }
}

@Composable
fun ProfileRating(
    user: UserMain,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp))
    {
        Column {
            Image(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .border(
                        width = 2.dp,
                        color = Color.Gray,
                        shape = CircleShape
                    ),
                painter = painterResource(R.drawable.image_test),
                contentDescription = "Like Icon"
            )
        }
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Row {
                Text(
                    modifier = Modifier.padding(start = 3.dp),
                    text = user.name,
                    style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp),
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
    Row {
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = "Comentar",
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 25.sp),
            fontWeight = FontWeight.Normal,
        )
    }
    Row {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = 5.dp
                )
                .border(
                    width = 2.dp, // deixar as mordas mais largas
                    color = Color.LightGray, // colocar um cinza mais claro
                    shape = MaterialTheme.shapes.medium
                ),
            shape = MaterialTheme.shapes.medium,
            colors = CardDefaults.cardColors(
                containerColor = Color.LightGray,
                contentColor = MaterialTheme.colorScheme.onSurface,
                disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
                disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "Compartilhe sua experiência...",
                        style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                        color = Color.Black, // nao to conseguindo alterar para cinza
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }

        }

    }
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 30.dp)
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Stars(rating = 0f, size = 60.dp)
    }
    Column(modifier = Modifier.padding(top = 30.dp)) {
        RatingItem(title = "Limpeza", rating = 0f)
        RatingItem(title = "Papel", rating = 0f)
        RatingItem(title = "Estrutura", rating = 0f)
        RatingItem(title = "Acessibilidade", rating = 0f)
        
    }

}

@Composable
fun RatingItem(title: String, rating: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(fontSize = 23.sp),
            fontWeight = FontWeight.Normal,
        )
        Stars(rating = rating, size = 30.dp)
    }

}

@Preview(showBackground = true)
@Composable
fun RatingPagePreview() {
    AppTheme {
        RatingPage(
            user = UserMain(
                id = 1,
                name = "@Luan Ribeiro",
                iconId = 1,
                numComments = 1,
                points = 1,
                email = "lohanne@email.com",
                password = "123456",
                position = Position(
                    latitude = 0.0,
                    longitude = 0.0
                ),
                historyComment = emptyList()
            )
        )
    }
}