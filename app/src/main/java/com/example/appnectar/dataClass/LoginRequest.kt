import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Call

// Data class para los datos de login
data class LoginRequest(val username: String, val password: String)

// Data class para la respuesta del login
data class LoginResponse(val token: String)

// Interfaz de Retrofit para el servicio de la API
interface FakeStoreApi {
    @POST("auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}
