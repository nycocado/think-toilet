package pt.iade.ei.thinktoilet.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pt.iade.ei.thinktoilet.test.generateToilet
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.ui.theme.montserratFontFamily

@Composable
fun LocationCard(
    toilet: Toilet
) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .border(3.dp, Color.LightGray, RoundedCornerShape(15.dp))
    ) { // Container (Serve para aplicar o border radius)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) { // Todos os elementos são colocados em linha
            Column(
                modifier = Modifier.weight(1f)
            ) { // Informações do local
                Row { // Nome
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = toilet.name,
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) { // Estrelas
                    Stars(toilet.getAverageRating())
                    Text(
                        modifier = Modifier.padding(horizontal = 5.dp),
                        text = "(${toilet.numComments})",
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
                Row { // Endereço
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = toilet.address,
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Column { // Distância
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = "800m",
                    fontFamily = montserratFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LocationCardPreview() {
    LocationCard(
        toilet = generateToilet()
    )
}