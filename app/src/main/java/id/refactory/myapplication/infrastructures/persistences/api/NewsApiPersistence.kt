package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.data.payload.api.news.NewsResponseData
import id.refactory.data.persistences.contracts.NewsPersistenceInterface
import id.refactory.myapplication.infrastructures.api.NewsApi
import io.reactivex.Observable

class NewsApiPersistence(private var newsApi: NewsApi) : NewsPersistenceInterface {
    override fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>> {
        return newsApi.getNews(params)
    }

    override fun postNews(params: NewsRequesttData): Observable<out NewsResponseData> {
        return newsApi.postNews(params)
    }
}