package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.user.NewsResponseData
import id.refactory.data.persistences.contracts.NewsPersistenceInterface
import id.refactory.myapplication.infrastructures.api.NewsApi
import io.reactivex.Observable

class NewsApiPersistence(private var userApi: NewsApi) : NewsPersistenceInterface {
    override fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>> {
        return userApi.getNews(params)
    }
}