package pt.iade.ei.thinktoilet.models

import pt.iade.ei.thinktoilet.model.RatingCategory
import pt.iade.ei.thinktoilet.model.Toilet
import pt.iade.ei.thinktoilet.model.UserForeigner
import java.time.LocalDateTime

class ToiletReviews(
    val toilet: Toilet,
    val user: UserForeigner,
    var comments: String,
    var ratingCategory: RatingCategory,
    var datetime: LocalDateTime,
)