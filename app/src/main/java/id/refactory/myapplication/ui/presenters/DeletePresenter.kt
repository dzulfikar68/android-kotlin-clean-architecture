package id.refactory.myapplication.ui.presenters

import id.refactory.domain.News
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.DeleteView
import id.refactory.usecases.DeleteNews
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

@Deprecated("Not used")
class DeletePresenter(
    var view: DeleteView.View?
) : DeleteView.Presenter {
    @Inject
    @Named("APIDeleteNewsUseCase")
    lateinit var deleteNews: DeleteNews

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadDeleteNews(path: Int) {
        deleteNews.deleteNews(DeleteNewsObserver(), path)
    }

    override fun onDestroy() {
        view = null
        deleteNews.dispose()
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
}