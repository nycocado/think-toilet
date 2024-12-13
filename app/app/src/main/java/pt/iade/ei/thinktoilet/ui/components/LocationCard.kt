package pt.iade.ei.thinktoilet.ui.components

import android.location.Location
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.tests.generateRandomToilet
import pt.iade.ei.thinktoilet.ui.theme.AppTheme


/**
         * Exibe as informações de um Toilet de maneira avançada usando um Card.
         *
         * @param toilet Objeto que contém as informações do Toilet a serem exibidas.
         * @param location Objeto que contém as informações do Toilet a serem exibidas.
         * @param onClick contém as informações do Toilet a serem exibidas.
         *
         * Esta função exibe as informações de um Toilet em um Card, incluindo
         * avaliação, nome, endereço e distância.
         *
         * Exemplo de uso:
         * ```
         * LocationCard(
         *         toilet = Toleits // Class Toilet
         *         location = Location(""),
         *         onClick = {}
         *     )
         * ```
         */
@Composable
fun LocationCard(
    toilet: Toilet,
    location: Location,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 8.dp
            )
            .border(
                width = 2.dp,
                color = Color.LightGray,
                shape = MaterialTheme.shapes.medium
            ),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest,
            contentColor = MaterialTheme.colorScheme.onSurface,
            disabledContainerColor = MaterialTheme.colorScheme.surfaceContainerLowest.copy(alpha = 0.5f),
            disabledContentColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(2.dp),
        onClick = {
            onClick(toilet.id!!)
        }
    ) { // Container (Serve para aplicar o border radius)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) { // Todos os elementos são colocados em linha
            Column(
                modifier = Modifier.weight(1f)
            ) { // Informações do local
                Row { // Nome
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = toilet.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) { // Estrelas
                    Stars(toilet.getAverageRating(), size = 14.dp)
                    Text(
                        modifier = Modifier.padding(horizontal = 2.dp),
                        text = "(${toilet.numComments})",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        lineHeight = 1.sp
                    )
                }
                Row { // Endereço
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = toilet.address,
                        style = MaterialTheme.typography.labelMedium,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
            Column { // Distância
                Text(
                    modifier = Modifier.padding(horizontal = 10.dp),
                    text = toilet.distanceToString(location.latitude, location.longitude),
                    style = MaterialTheme.typography.titleLarge,
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
    AppTheme{
        LocationCard(
            toilet = generateRandomToilet(numComments = 10),
            location = Location(""),
            onClick = {}
        )
    }
}