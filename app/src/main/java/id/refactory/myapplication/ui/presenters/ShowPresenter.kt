package id.refactory.myapplication.ui.presenters

import id.refactory.domain.News
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.ShowView
import id.refactory.usecases.ShowNews
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class ShowPresenter(var view: ShowView.View?) : ShowView.Presenter {
    @Inject
    @Named("APIShowNewsUseCase")
    lateinit var showNews: ShowNews

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadShowNews(path: Int) {
        showNews.showNews(ShowNewsObserver(), path)
    }

    override fun onDestroy() {
        view = null
        showNews.dispose()
    }

    inner class ShowNewsObserver : DisposableObserver<News>() {
        override fun onComplete() {}
        override fun onNext(t: News) {
            view?.onSuccessShowNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }

}