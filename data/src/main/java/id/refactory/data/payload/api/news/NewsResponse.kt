package id.refactory.data.payload.api.news

data class NewsResponseData(
    val id: Long,
    val userId: Long,
    val title: String,
    val body: String
)

//data class GetNewsApiResponse(val data: List<NewsResponseData>) : GetNewsResponseInterface