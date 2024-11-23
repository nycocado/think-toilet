package pt.iade.ei.thinktoilet.network

import pt.iade.ei.thinktoilet.models.Comment
import pt.iade.ei.thinktoilet.models.PageResponse
import pt.iade.ei.thinktoilet.models.Toilet
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ToiletService {
    @GET("toilets")
    suspend fun getToilets(): List<Toilet>

    @GET("toilets/{id}")
    suspend fun getToiletById(@Path("id") id: Int): Toilet

    @GET("toilets/{id}/comments")
    suspend fun getCommentsByToiletId(@Path("id") id: Int): List<Comment>

    @GET("toilets/nearby?lat={latitude}&lon={longitude}")
    suspend fun getNearbyToilets(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double
    ): List<Toilet>
}