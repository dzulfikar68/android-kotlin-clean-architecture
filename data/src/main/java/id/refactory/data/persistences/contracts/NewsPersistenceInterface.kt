package id.refactory.data.persistences.contracts

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.data.payload.api.news.NewsResponseData
import io.reactivex.Observable

interface NewsPersistenceInterface {
    fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>>
    fun postNews(params: NewsRequestData): Observable<out NewsResponseData>
    fun showNews(path: Int): Observable<out NewsResponseData>
    fun deleteNews(path: Int): Observable<out NewsResponseData>
    fun putNews(path: Int, body: NewsRequestData): Observable<out NewsResponseData>
}