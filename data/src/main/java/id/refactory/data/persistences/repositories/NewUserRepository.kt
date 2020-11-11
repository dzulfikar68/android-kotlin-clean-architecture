package id.refactory.data.persistences.repositories

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.data.payload.contracts.RepositoryInterface
import id.refactory.data.persistences.contracts.NewUserPersistenceInterface
import id.refactory.data.persistences.mappers.NewUserDataMapper
import id.refactory.domain.NewUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NewUserRepository(
    private val persistence: NewUserPersistenceInterface,
    private val mapper: NewUserDataMapper
) : RepositoryInterface {
    suspend fun getNewUsers(params: Map<String, String>): Flow<List<NewUser>> {
        return persistence.getNewUsers(params).map {
            mapper.convertNewUserList(it)
        }
    }

    suspend fun showNewUsers(path: Int): Flow<NewUser?> {
        return persistence.showNewUsers(path).map {
            mapper.convertNewUser(it)
        }
    }

    suspend fun addNewUsers(param: NewUserApiRequest): Flow<NewUser?> {
        return persistence.addNewUsers(param).map {
            mapper.convertNewUser(it)
        }
    }

    suspend fun editNewUsers(path: Int, param: NewUserApiRequest): Flow<NewUser?> {
        return persistence.editNewUsers(path, param).map {
            mapper.convertNewUser(it)
        }
    }

    suspend fun deleteNewUsers(path: Int): Flow<NewUser?> {
        return persistence.deleteNewUsers(path).map {
            mapper.convertNewUser(it)
        }
    }
}