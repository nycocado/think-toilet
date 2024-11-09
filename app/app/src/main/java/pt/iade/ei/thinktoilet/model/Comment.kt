package pt.iade.ei.thinktoilet.model

import java.io.Serializable
import java.time.LocalDateTime

data class Comment(
    var id: Int?,
    val userForeigner: UserForeigner,
    val rate: Float,
    val text: String,
    val ratingCategory: RatingCategory,
    val datetime: LocalDateTime,
    val like: Int,
    val dislike: Int
) : Serializable