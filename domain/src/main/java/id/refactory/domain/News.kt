package id.refactory.domain

data class News(
    var id: Long? = null,
    var userId: Long? = null,
    var title: String? = null,
    var description: String? = null
)