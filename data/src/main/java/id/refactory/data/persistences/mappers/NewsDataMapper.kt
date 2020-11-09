package id.refactory.data.persistences.mappers

import id.refactory.data.payload.api.user.NewsResponseData
import id.refactory.domain.News

class NewsDataMapper {
    fun convertNewsList(result: List<NewsResponseData>?): List<News> {
        val response = mutableListOf<News>()
        result?.forEach {
            response.add(
                News(
                    id = it.id,
                    userId = it.userId,
                    title = it.title,
                    description = it.body
                )
            )
        }
        return response
    }
}