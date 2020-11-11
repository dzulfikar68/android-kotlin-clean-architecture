package id.refactory.data.payload.api.news

data class NewsRequestData(
    val id: Long? = null,
    val title: String?,
    val body: String?
)