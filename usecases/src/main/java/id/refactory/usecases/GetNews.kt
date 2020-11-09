package id.refactory.usecases

import id.refactory.data.persistences.repositories.NewsRepository
import id.refactory.domain.News
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class GetNews(
    private var repository: NewsRepository,
    private var compositeDisposable: CompositeDisposable,
    private var observerScheduler: Scheduler
) {
    fun getNews(observer: DisposableObserver<List<News>>, params: Map<String, String>) {
        val observable = repository.getNews(params)
            .subscribeOn(Schedulers.newThread())
            .observeOn(observerScheduler)

        compositeDisposable.add(observable.subscribeWith(observer))
    }

    fun dispose() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}