package pt.iade.ei.thinktoilet.models

import java.io.Serializable

data class User(
    var id: Int?,
    var name: String?,
    var iconId: Int?,
    var numComments: Int?,
    var points: Int?
): Serializable // //! falta criar o sistema de pontos