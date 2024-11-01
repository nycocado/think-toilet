package pt.iade.ei.thinktoilet.test

import pt.iade.ei.thinktoilet.models.Comment
import pt.iade.ei.thinktoilet.models.Position
import pt.iade.ei.thinktoilet.models.RatingCategory
import pt.iade.ei.thinktoilet.models.Toilet
import pt.iade.ei.thinktoilet.models.UserForeigner
import java.time.LocalDateTime

fun generateRatingCategory(): RatingCategory {
    return RatingCategory(
        clean = 1.0f,
        paper = 1.0f,
        structure = 1.0f,
        accessibility = 1.0f,
    )
}

fun generatePosition(): Position {
    return Position(
        latitude = 0.0,
        longitude = 0.0
    )
}

fun generateToilet(): Toilet {
    return Toilet(
        id = 1,
        name = "Toiletaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        address = "Addressaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        ratingCategory = generateRatingCategory(),
        accessibility = true,
        babyChangingStation = true,
        position = generatePosition(),
        numComments = 0,
        comments = emptyList(),
        googlePlaceId = "0"
    )
}

fun generateUser(): UserForeigner {
    return UserForeigner(
        id = 1,
        name = "Nycolas",
        iconId = 1,
        numComments = 1,
        points = 1
    )
}

fun generateComment(): Comment {
    return Comment(
        id = 13,
        userForeigner = generateUser(),
        rate = 2.8f,
        commentsTime = 20,
        text = "Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment Comment",
        ratingCategory = generateRatingCategory(),
        date = LocalDateTime.now(),
        like = 527,
        dislike = 97

    )
    // Padrao para Text
    /**
     * Text(
     *       text = "texto",                        texto
     *       fontFamily = montserratFontFamily,     estilo da fonte
     *       fontWeight = FontWeight.Normal,        tamanho da fonte
     *       )
     * **/
}