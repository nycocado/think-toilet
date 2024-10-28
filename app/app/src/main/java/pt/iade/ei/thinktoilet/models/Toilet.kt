package pt.iade.ei.thinktoilet.models

import java.io.Serializable

data class Toilet(
    var id: Int?,
    val name: String,
    val address: String,
    var ratingAverage: Float?,
    var numCommets: Int?,
    val position: Position,
) : Serializable
