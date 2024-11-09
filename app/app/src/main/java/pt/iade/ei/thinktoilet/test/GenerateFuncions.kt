package pt.iade.ei.thinktoilet.test

import pt.iade.ei.thinktoilet.model.Comment
import pt.iade.ei.thinktoilet.model.Position
import pt.iade.ei.thinktoilet.model.RatingCategory
import pt.iade.ei.thinktoilet.model.Toilet
import pt.iade.ei.thinktoilet.model.UserForeigner
import java.time.LocalDateTime

fun generateRandomRatingCategory(): RatingCategory {
    return RatingCategory(
        clean = (0..5).random().toFloat(),
        paper = (0..5).random().toFloat(),
        structure = (0..5).random().toFloat(),
        accessibility = (0..5).random().toFloat(),
    )
}

fun generateRandomPosition(): Position {
    return Position(
        latitude = (0..100).random().toDouble(),
        longitude = (0..100).random().toDouble()
    )
}

fun generateRandomToilet(): Toilet{
    return Toilet(
        id = 1,
        name = "Toilet ${(0..100).random()}",
        address = "Address ${(0..100).random()}",
        ratingCategory = generateRandomRatingCategory(),
        accessibility = (0..1).random() == 1,
        babyChangingStation = (0..1).random() == 1,
        position = generateRandomPosition(),
        numComments = 0,
        comments = emptyList(),
        googlePlaceId = "0",
        distance = generateRandomDistance()
    )
}

fun generateRandomToiletWithComments(): Toilet {
    val toilet = generateRandomToilet()
    val comments = mutableListOf<Comment>()
    for (i in 1..(1..15).random()) {
        comments.add(generateComment())
    }
    toilet.comments = comments
    toilet.numComments = comments.size
    return toilet
}

fun generateRandomToilets(numToilets: Int): List<Toilet> {
    val toilets = mutableListOf<Toilet>()
    for (i in 1..numToilets) {
        toilets.add(generateRandomToilet())
    }
    return toilets
}

fun generateRandomToiletsWithComments(numToilets: Int): List<Toilet> {
    val toilets = mutableListOf<Toilet>()
    for (i in 1..numToilets) {
        toilets.add(generateRandomToiletWithComments())
    }
    return toilets
}

fun generateRandomDistance(): Double {
    return (0..5000).random().toDouble()
}

fun generateUser(): UserForeigner {
    return UserForeigner(
        id = 1,
        name = "Luan Ribeiro",
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
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc ac varius ex. Morbi vitae fermentum dui. Sed in laoreet massa. Donec sed pretium ipsum. Phasellus diam nunc, hendrerit laoreet imperdiet sit amet, ornare ut diam. Sed augue nisl, sollicitudin id dui sit amet, auctor faucibus odio. Nulla hendrerit gravida lacus ut aliquet.",
        ratingCategory = generateRandomRatingCategory(),
        datetime = LocalDateTime.now(),
        like = 527,
        dislike = 97
    )
}