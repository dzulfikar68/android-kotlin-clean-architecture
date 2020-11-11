package id.refactory.myapplication.ui.views

import id.refactory.domain.News

@Deprecated("Not used")
interface DeleteView {
    interface View : BaseView<Presenter> {
        fun onSuccessDeleteNews(news: News)
    }

    interface Presenter : BasePresenter {
        fun onLoadDeleteNews(path: Int)
    }
}