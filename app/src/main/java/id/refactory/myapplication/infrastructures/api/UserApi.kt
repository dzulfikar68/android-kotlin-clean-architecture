package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.user.GetUsersApiResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserApi {
    @GET("db")
    suspend fun getUsers(@QueryMap queries: Map<String, String>): GetUsersApiResponse
}