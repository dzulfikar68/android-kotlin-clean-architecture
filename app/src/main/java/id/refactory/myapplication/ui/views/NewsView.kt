package id.refactory.myapplication.ui.views

import id.refactory.domain.News

interface NewsView {
    interface View : BaseView<Presenter> {
        fun onSuccessLoadNews(news: List<News>)
    }

    interface Presenter : BasePresenter {
        fun onLoadNews(params: Map<String, String>)
    }
}