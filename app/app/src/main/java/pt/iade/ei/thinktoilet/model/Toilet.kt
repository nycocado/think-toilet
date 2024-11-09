package pt.iade.ei.thinktoilet.model

import java.io.Serializable

data class Toilet(
    var id: Int?,
    val name: String,
    val address: String,
    var ratingCategory: RatingCategory,
    val accessibility: Boolean,
    val babyChangingStation: Boolean,
    val position: Position,
    var numComments: Int,
    var comments: List<Comment>,
    val googlePlaceId: String,
    val distance: Double
) : Serializable {
    fun getAverageRating(): Float {
        return ratingCategory.average()
    }
}