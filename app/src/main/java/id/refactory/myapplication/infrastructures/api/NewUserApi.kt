package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.user.GetNewUserApiResponse
import id.refactory.data.payload.api.user.GetNewUsersApiResponse
import id.refactory.data.payload.api.user.NewUserApiRequest
import retrofit2.http.*

interface NewUserApi {
    @GET(Constants.NEW_USER)
    suspend fun getNewUser(
        @QueryMap queries: Map<String, String>,
        @Header("Authorization") token: String
    ): GetNewUsersApiResponse

    @GET("${Constants.NEW_USER}/{id}")
    suspend fun showNewUser(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): GetNewUserApiResponse

    @POST(Constants.NEW_USER)
    suspend fun addNewUser(
        @Body body: NewUserApiRequest,
        @Header("Authorization") token: String
    ): GetNewUserApiResponse

    @PUT("${Constants.NEW_USER}/{id}")
    suspend fun editNewUser(
        @Path("id") id: Int,
        @Body body: NewUserApiRequest,
        @Header("Authorization") token: String
    ): GetNewUserApiResponse

    @DELETE("${Constants.NEW_USER}/{id}")
    suspend fun deleteNewUser(
        @Path("id") id: Int,
        @Header("Authorization") token: String
    ): GetNewUserApiResponse
}