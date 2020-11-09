package id.refactory.data.persistences.repositories

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

}