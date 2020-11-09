package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.news.NewsRequesttData
import id.refactory.domain.News
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.AddView
import id.refactory.usecases.PostNews
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class AddPresenter(var view: AddView.View?) : AddView.Presenter {
    @Inject
    @Named("APIPostNewsUseCase")
    lateinit var postNews: PostNews

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadSubmitNews(params: NewsRequesttData) {
        postNews.postNews(PostNewsObserver(), params)
    }

    override fun onDestroy() {
        view = null
        postNews.dispose()
    }

    inner class PostNewsObserver : DisposableObserver<News>() {
        override fun onComplete() {}
        override fun onNext(t: News) {
            view?.onSuccessSubmitNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }

}