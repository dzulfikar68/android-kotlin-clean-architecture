package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.user.GetUsersApiResponse
import id.refactory.data.persistences.contracts.UserPersistenceInterface
import id.refactory.myapplication.infrastructures.api.UserApi

// get from api
class UserApiPersistence(private var userApi: UserApi): UserPersistenceInterface {
    override suspend fun getUsers(params: Map<String, String>): GetUsersApiResponse {
        return userApi.getUsers(params)
    }
}