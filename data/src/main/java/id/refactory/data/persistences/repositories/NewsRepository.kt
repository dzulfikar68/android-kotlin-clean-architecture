package id.refactory.data.persistences.repositories

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.data.payload.contracts.RepositoryInterface
import id.refactory.data.persistences.contracts.NewsPersistenceInterface
import id.refactory.data.persistences.mappers.NewsDataMapper
import id.refactory.domain.News
import io.reactivex.Observable

class NewsRepository(
    private val persistence: NewsPersistenceInterface,
    private val mapper: NewsDataMapper
) : RepositoryInterface {

    fun getNews(params: Map<String, String>): Observable<List<News>> {
        return persistence.getNews(params).map {
            mapper.convertNewsList(it)
        }
    }

    fun showNews(path: Int): Observable<News> {
        return persistence.showNews(path).map {
            mapper.convertNews(it)
        }
    }

    fun deleteNews(path: Int): Observable<News> {
        return persistence.deleteNews(path).map {
            mapper.convertNews(it)
        }
    }

    fun putNews(path: Int, body: NewsRequestData): Observable<News> {
        return persistence.putNews(path, body).map {
            mapper.convertNews(it)
        }
    }

    fun postNews(params: NewsRequestData): Observable<News> {
        return persistence.postNews(params).map {
            mapper.convertNews(it)
        }
    }

}