package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.data.payload.api.news.NewsResponseData
import io.reactivex.Observable
import retrofit2.http.*

interface NewsApi {
    @GET("posts")
    fun getNews(@QueryMap queries: Map<String, String>): Observable<List<NewsResponseData>>

    @POST("posts")
    fun postNews(@Body body: NewsRequestData): Observable<NewsResponseData>

    @GET("posts/{id}")
    fun showNews(@Path("id") path: Int): Observable<NewsResponseData>

    @PUT("posts/{id}")
    fun putNews(@Path("id") path: Int, @Body body: NewsRequestData): Observable<NewsResponseData>

    @DELETE("posts/{id}")
    fun deleteNews(@Path("id") path: Int): Observable<NewsResponseData>
}