package pt.iade.ei.thinktoilet.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.R
import pt.iade.ei.thinktoilet.ui.theme.AppTheme
import pt.iade.ei.thinktoilet.ui.util.NoRippleInteractionSource

@Composable
fun ThumbDown(
    count: Int = 0,
    size: Dp = 28.dp,
    isPressed: Boolean = false,
    onClick: (Boolean) -> Unit = {},
) {
    val context = LocalContext.current

    Surface(
        onClick = {
            onClick(isPressed)
        },
        interactionSource = NoRippleInteractionSource(),
        color = Color.Transparent
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(
                    if (!isPressed) R.drawable.thumb_down_24px
                    else R.drawable.thumb_down_filled_24px
                ),
                contentDescription = context.getString(R.string.content_description_dislike_button),
                modifier = Modifier
                    .size(size)
                    .padding(end = 4.dp)
            )
            Text(
                text = count.toString(),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ThumbDownPreview() {
    AppTheme {
        ThumbDown()
    }
}