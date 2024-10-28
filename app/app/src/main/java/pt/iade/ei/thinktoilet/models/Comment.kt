package pt.iade.ei.thinktoilet.models

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

data class Comment(
    var id: Int?,
    val user: User,
    val text: String,
    val ratingCategory: RatingCategory,
    val date: LocalDateTime,
) : Serializable