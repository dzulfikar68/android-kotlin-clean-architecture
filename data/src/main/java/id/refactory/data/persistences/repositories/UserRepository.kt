package id.refactory.data.persistences.repositories

import id.refactory.data.payload.contracts.RepositoryInterface
import id.refactory.data.persistences.contracts.UserPersistenceInterface
import id.refactory.data.persistences.mappers.UserDataMapper
import id.refactory.domain.User

class UserRepository(private val persistence: UserPersistenceInterface, private val mapper: UserDataMapper): RepositoryInterface {
    suspend fun getUsers(params: Map<String, String>): List<User> {
        return mapper.convertUserList(persistence.getUsers(params))
    }
}