package id.refactory.myapplication.infrastructures.persistences.api

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.data.payload.api.news.NewsResponseData
import id.refactory.data.persistences.contracts.NewsPersistenceInterface
import id.refactory.myapplication.infrastructures.api.NewsApi
import io.reactivex.Observable

class NewsApiPersistence(private var newsApi: NewsApi) : NewsPersistenceInterface {
    override fun getNews(params: Map<String, String>): Observable<out List<NewsResponseData>> {
        return newsApi.getNews(params)
    }

    override fun postNews(params: NewsRequestData): Observable<out NewsResponseData> {
        return newsApi.postNews(params)
    }

    override fun showNews(path: Int): Observable<out NewsResponseData> {
        return newsApi.showNews(path)
    }

    override fun deleteNews(path: Int): Observable<out NewsResponseData> {
        return newsApi.deleteNews(path)
    }

    override fun putNews(path: Int, body: NewsRequestData): Observable<out NewsResponseData> {
        return newsApi.putNews(path, body)
    }
}