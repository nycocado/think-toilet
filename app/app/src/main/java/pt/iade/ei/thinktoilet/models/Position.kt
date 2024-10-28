package pt.iade.ei.thinktoilet.models

import java.io.Serializable

data class Position(
    val latitude: Double,
    val longitude: Double,
) : Serializable