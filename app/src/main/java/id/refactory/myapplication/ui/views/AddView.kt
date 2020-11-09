package id.refactory.myapplication.ui.views

import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.domain.News

interface AddView {
    interface View : BaseView<Presenter> {
        fun onSuccessSubmitNews(news: News)
    }

    interface Presenter : BasePresenter {
        fun onLoadSubmitNews(params: NewsRequesttData)
    }
}