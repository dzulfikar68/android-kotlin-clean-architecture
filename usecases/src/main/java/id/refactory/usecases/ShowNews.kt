package id.refactory.usecases

import id.refactory.data.persistences.repositories.NewsRepository
import id.refactory.domain.News
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class ShowNews(
    private var repository: NewsRepository,
    private var compositeDisposable: CompositeDisposable,
    private var observerScheduler: Scheduler
) {
    fun showNews(observer: DisposableObserver<News>, params: Map<String, String>) {
        val observable = repository.showNews(params)
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