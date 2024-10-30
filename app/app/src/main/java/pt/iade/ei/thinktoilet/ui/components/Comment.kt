package pt.iade.ei.thinktoilet.ui.components

import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
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
    Column {
        Row {
            Text(
                text = "Linha One",
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.Normal,
            )
        }
        Row {

            Text(
                text = comment.text,
                fontFamily = montserratFontFamily,
                fontWeight = FontWeight.Normal,
                //modifier = Modifier.padding(10.dp)
            )
        }
        Row {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.like),
                        contentDescription = "Like Icon"
                    )
                    Text(
                        text = comment.dislike.toString()
                    )
                }
            }
            Column(
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(10.dp, 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.dislike),
                        contentDescription = "Like Icon"
                    )
                    Text(
                        text = comment.dislike.toString(),
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


