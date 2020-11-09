package id.refactory.myapplication.ui.presenters

import id.refactory.domain.News
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.NewsView
import id.refactory.usecases.GetNews
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class NewsPresenter(var view: NewsView.View?) : NewsView.Presenter {
    @Inject
    @Named("APIGetNewsUseCase")
    lateinit var getNews: GetNews

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadNews(params: Map<String, String>) {
        getNews.getNews(GetNewsObserver(), params)
    }

    override fun onDestroy() {
        view = null
        getNews.dispose()
    }

    inner class GetNewsObserver : DisposableObserver<List<News>>() {
        override fun onComplete() {}
        override fun onNext(t: List<News>) {
            view?.onSuccessLoadNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}