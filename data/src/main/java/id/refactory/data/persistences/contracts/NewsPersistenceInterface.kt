package id.refactory.data.persistences.contracts

import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.data.payload.api.news.NewsResponseData
import io.reactivex.Observable

interface NewsPersistenceInterface {
    fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>>
    fun postNews(params: NewsRequesttData): Observable<out NewsResponseData>
    fun showNews(params: Map<String, String>): Observable<out NewsResponseData>
}