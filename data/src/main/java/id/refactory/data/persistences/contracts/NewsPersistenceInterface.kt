package id.refactory.data.persistences.contracts

import id.refactory.data.payload.api.user.NewsResponseData
import io.reactivex.Observable

interface NewsPersistenceInterface {
    fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>>
}