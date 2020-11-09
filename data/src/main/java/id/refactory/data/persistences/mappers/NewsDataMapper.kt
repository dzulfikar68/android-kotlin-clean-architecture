package id.refactory.data.persistences.mappers

import id.refactory.data.payload.api.news.NewsResponseData
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

    fun convertNews(result: NewsResponseData?): News {
        return News(
            id = result?.id,
            userId = result?.userId,
            title = result?.title,
            description = result?.body
        )
    }
}