package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.data.payload.api.news.NewsResponseData
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

interface NewsApi {
    @GET("posts")
    fun getNews(@QueryMap queries: Map<String, String>): Observable<List<NewsResponseData>>

    @POST("posts")
    fun postNews(@Body queries: NewsRequesttData): Observable<NewsResponseData>
}