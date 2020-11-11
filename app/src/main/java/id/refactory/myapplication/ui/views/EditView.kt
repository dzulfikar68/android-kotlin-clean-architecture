package id.refactory.myapplication.ui.views

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.domain.News

interface EditView {
    interface View : BaseView<Presenter> {
        fun onSuccessLoadNews(news: News)
        fun onSuccessSubmitNews(news: News)
        fun onSuccessDeleteNews(news: News)
    }

    interface Presenter : BasePresenter {
        fun onLoadSubmitNews(path: Int, body: NewsRequestData)
        fun onLoadDeleteNews(path: Int)
        fun onLoadShowNews(path: Int)
    }
}