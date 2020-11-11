package id.refactory.data.payload.api.user

data class NewUserApiRequest(
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?
)