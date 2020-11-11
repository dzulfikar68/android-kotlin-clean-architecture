package id.refactory.data.persistences.contracts

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.data.payload.contracts.GetNewUserResponseInterface
import kotlinx.coroutines.flow.Flow

interface NewUserPersistenceInterface {
    suspend fun getNewUsers(params: Map<String, String>): Flow<GetNewUserResponseInterface>
    suspend fun showNewUsers(path: Int): Flow<GetNewUserResponseInterface>
    suspend fun addNewUsers(param: NewUserApiRequest): Flow<GetNewUserResponseInterface>
    suspend fun editNewUsers(path: Int, param: NewUserApiRequest): Flow<GetNewUserResponseInterface>
    suspend fun deleteNewUsers(path: Int): Flow<GetNewUserResponseInterface>
}