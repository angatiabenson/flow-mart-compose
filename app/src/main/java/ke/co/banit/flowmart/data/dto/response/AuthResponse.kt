package ke.co.banit.flowmart.data.dto.response

import com.google.gson.annotations.SerializedName
import ke.co.banit.flowmart.domain.models.User

data class AuthResponse(
    @SerializedName("api_key")
    val apiKey: String,
    val message: String,
    val status: String,
    val user: UserDto
) {
    data class UserDto(
        val email: String,
        val id: Int,
        val name: String,
        val phone: String
    )
}

fun AuthResponse.toDomain(): User {
    return User(
        email = this.user.email,
        id = this.user.id,
        name = this.user.name,
        phone = this.user.phone,
        apiKey = this.apiKey
    )
}
