package pt.iade.ei.thinktoilet.network

import pt.iade.ei.thinktoilet.models.ApiResponse
import pt.iade.ei.thinktoilet.models.LoginRequest
import pt.iade.ei.thinktoilet.models.RegisterRequest
import pt.iade.ei.thinktoilet.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("auth/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<User>

    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<ApiResponse>
}