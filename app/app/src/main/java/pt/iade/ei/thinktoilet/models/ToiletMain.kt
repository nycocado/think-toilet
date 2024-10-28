package pt.iade.ei.thinktoilet.models

import java.io.Serializable

data class ToiletMain(
    val toiletMain: ToiletMain,
    val acessibility: Boolean,
    val babyChangingStation: Boolean,
    var ratingCategory: RatingCategory,
    val comments: List<Comment>,
    val googlePlaceId: String,
) : Serializable
