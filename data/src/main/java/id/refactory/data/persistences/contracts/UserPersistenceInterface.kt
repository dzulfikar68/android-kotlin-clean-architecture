package id.refactory.data.persistences.contracts

import id.refactory.data.payload.contracts.GetUsersResponseInterface

interface UserPersistenceInterface {
    suspend fun getUsers(params: Map<String, String>): GetUsersResponseInterface
}