package pt.iade.ei.thinktoilet.models

import java.io.Serializable

data class RatingCategory(
    var clean: Float?,
    var paper: Float?,
    var structure: Float?,
    var acessibiiity: Float?,
) : Serializable
