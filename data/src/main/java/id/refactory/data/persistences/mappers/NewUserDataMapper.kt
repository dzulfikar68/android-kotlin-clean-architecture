package id.refactory.data.persistences.mappers

import id.refactory.data.payload.api.user.GetNewUserApiResponse
import id.refactory.data.payload.api.user.GetNewUsersApiResponse
import id.refactory.data.payload.contracts.GetNewUserResponseInterface
import id.refactory.domain.NewUser

class NewUserDataMapper {
    fun convertNewUserList(result: GetNewUserResponseInterface?): List<NewUser> {
        val response = mutableListOf<NewUser>()

        if (result is GetNewUsersApiResponse) {
            result.data?.forEach {
                response.add(
                    NewUser(
                        id = it.id,
                        name = it.name,
                        email = it.email,
                        gender = it.gender,
                        status = it.status,
                        date = it.created_at
                    )
                )
            }
        }
        return response
    }

    fun convertNewUser(result: GetNewUserResponseInterface?): NewUser? {
        return if (result is GetNewUserApiResponse) {
            NewUser(
                id = result.data?.id,
                name = result.data?.name,
                email = result.data?.email,
                gender = result.data?.gender,
                status = result.data?.status,
                date = result.data?.created_at
            )
        } else null
    }
}