package pt.iade.ei.thinktoilet.ui.components

import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.R
import pt.iade.ei.thinktoilet.models.Comment
import pt.iade.ei.thinktoilet.test.generateComment
import pt.iade.ei.thinktoilet.ui.theme.montserratFontFamily


@Composable
fun Comment(
    comment: Comment,
) {
    HorizontalDivider(
        thickness = 2.dp,
        color = Color.LightGray
    )
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp, 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                horizontalAlignment = Alignment.Start
            ) {

                Row(modifier = Modifier.padding(bottom = 5.dp)) {
                    Image(
                        modifier = Modifier
                            .size(60.dp)
                            .clip(CircleShape)
                            .border(2.dp, Color.Gray, CircleShape),
                        painter = painterResource(id = R.drawable.image_test),
                        contentDescription = "Like Icon"
                    )
                    Column(modifier = Modifier.padding(10.dp)) {
                        Row {
                            Text(
                                comment.userForeigner.name,
                                fontFamily = montserratFontFamily,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Row(
                            modifier = Modifier.padding(top = 5.dp)
                        ) {
                            Text(
                                comment.userForeigner.numComments.toString() + " Avaliações",
                                fontFamily = montserratFontFamily,
                                fontWeight = FontWeight.SemiBold,
                                
                            )
                        }
                    }
                }
                Stars(
                    rating = comment.rate,
                    size = 20.dp
                )
            }

            Column(
                horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier.padding(end = 12.dp)

                ) {
                    Text(
                        "há uma Semana",
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
        Row {

            Text(
                text = comment.text,
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(12.dp, 6.dp)
            )
        }
        Row(
            modifier = Modifier.padding(12.dp, 3.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(end = 10.dp)
                    .width(70.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Icon",
                        Modifier.padding(end = 5.dp)
                    )
                    Text(
                        text = comment.like.toString(),
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,

                        )
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Row(
                    modifier = Modifier.padding(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dislike),
                        contentDescription = "Like Icon",
                        Modifier.padding(end = 5.dp)

                    )
                    Text(
                        text = comment.dislike.toString(),
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun CommentPreview() {
    Comment(
        comment = generateComment()
    )
}


