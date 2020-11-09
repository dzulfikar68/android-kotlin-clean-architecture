package id.refactory.myapplication.infrastructures.api

import id.refactory.data.payload.api.user.NewsResponseData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface NewsApi {
    @GET("posts")
    fun getNews(@QueryMap queries: Map<String, String>): Observable<List<NewsResponseData>>
}