package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.data.payload.contracts.GetNewUserResponseInterface
import id.refactory.data.persistences.contracts.NewUserPersistenceInterface
import id.refactory.myapplication.infrastructures.api.NewUserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewUserApiPersistence(private var newUserApi: NewUserApi) : NewUserPersistenceInterface {
    override suspend fun getNewUsers(params: Map<String, String>): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.getNewUser(params))
        }
    }

    override suspend fun showNewUsers(path: Int): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.showNewUser(path))
        }
    }

    override suspend fun addNewUsers(param: NewUserApiRequest): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.addNewUser(param))
        }
    }

    override suspend fun editNewUsers(
        path: Int,
        param: NewUserApiRequest
    ): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.editNewUser(path, param))
        }
    }

    override suspend fun deleteNewUsers(path: Int): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.deleteNewUser(path))
        }
    }

}