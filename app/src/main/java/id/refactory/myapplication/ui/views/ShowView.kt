package id.refactory.myapplication.ui.views

import id.refactory.domain.News

interface ShowView {
    interface View : BaseView<Presenter> {
        fun onSuccessShowNews(news: News)
    }

    interface Presenter : BasePresenter {
        fun onLoadShowNews(path: Int)
    }
}