package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.news.NewsRequestData
import id.refactory.domain.News
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.EditView
import id.refactory.usecases.DeleteNews
import id.refactory.usecases.PutNews
import id.refactory.usecases.ShowNews
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class EditPresenter(var view: EditView.View?) : EditView.Presenter {
    @Inject
    @Named("APIPutNewsUseCase")
    lateinit var editNews: PutNews

    @Inject
    @Named("APIDeleteNewsUseCase")
    lateinit var deleteNews: DeleteNews

    @Inject
    @Named("APIShowNewsUseCase")
    lateinit var showNews: ShowNews

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadSubmitNews(path: Int, body: NewsRequestData) {
        editNews.putNews(EditNewsObserver(), path, body)
    }

    override fun onLoadDeleteNews(path: Int) {
        deleteNews.deleteNews(DeleteNewsObserver(), path)
    }

    override fun onLoadShowNews(path: Int) {
        showNews.showNews(ShowNewsObserver(), path)
    }

    override fun onDestroy() {
        view = null
        editNews.dispose()
        deleteNews.dispose()
        showNews.dispose()
    }

    inner class EditNewsObserver : DisposableObserver<News>() {
        override fun onComplete() {}
        override fun onNext(t: News) {
            view?.onSuccessSubmitNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }

    inner class DeleteNewsObserver : DisposableObserver<News>() {
        override fun onComplete() {}
        override fun onNext(t: News) {
            view?.onSuccessDeleteNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }

    inner class ShowNewsObserver : DisposableObserver<News>() {
        override fun onComplete() {}
        override fun onNext(t: News) {
            view?.onSuccessLoadNews(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }

}