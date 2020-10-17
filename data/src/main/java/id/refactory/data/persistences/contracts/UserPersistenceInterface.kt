package id.refactory.data.persistences.contracts

import id.refactory.data.payload.contracts.GetUsersResponseInterface
import kotlinx.coroutines.flow.Flow

interface UserPersistenceInterface {
    suspend fun getUsers(params: Map<String, String>): Flow<GetUsersResponseInterface>
}