package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.data.payload.contracts.GetNewUserResponseInterface
import id.refactory.data.persistences.contracts.NewUserPersistenceInterface
import id.refactory.myapplication.infrastructures.api.NewUserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewUserApiPersistence(private var newUserApi: NewUserApi) : NewUserPersistenceInterface {
    companion object {
        const val TOKEN = "Bearer 565d3c21a7ab169e5324608204651a0f3795e6747c809f9b3b800e4ddf1b2c2b"
    }

    override suspend fun getNewUsers(params: Map<String, String>): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.getNewUser(params, TOKEN))
        }
    }

    override suspend fun showNewUsers(path: Int): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.showNewUser(path, TOKEN))
        }
    }

    override suspend fun addNewUsers(param: NewUserApiRequest): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.addNewUser(param, TOKEN))
        }
    }

    override suspend fun editNewUsers(
        path: Int,
        param: NewUserApiRequest
    ): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.editNewUser(path, param, TOKEN))
        }
    }

    override suspend fun deleteNewUsers(path: Int): Flow<GetNewUserResponseInterface> {
        return flow {
            emit(newUserApi.deleteNewUser(path, TOKEN))
        }
    }

}