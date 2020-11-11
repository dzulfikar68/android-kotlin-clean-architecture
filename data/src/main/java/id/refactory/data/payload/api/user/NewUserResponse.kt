package id.refactory.data.payload.api.user

import id.refactory.data.payload.contracts.GetNewUserResponseInterface

data class GetNewUsersApiResponse(
    val code: Int?,
    val meta: Any?,
    val data: List<NewUserResponseData>?
) : GetNewUserResponseInterface

data class GetNewUserApiResponse(
    val code: Int?,
    val meta: Any?,
    val data: NewUserResponseData?
) : GetNewUserResponseInterface

data class NewUserResponseData(
    val id: Long?,
    val name: String?,
    val email: String?,
    val gender: String?,
    val status: String?,
    val created_at: String?,
    val updated_at: String?,
    val message: String?
)