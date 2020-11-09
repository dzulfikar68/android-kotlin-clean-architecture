package id.refactory.myapplication.ui.presenters

import id.refactory.domain.User
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.MainView
import id.refactory.usecases.GetUsers
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import javax.inject.Named

class MainPresenter (var view: MainView.View?): MainView.Presenter {

    @Inject
    @Named("APIGetUserUseCase")
    lateinit var getUsers: GetUsers

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadUsers(params: Map<String, String>) {
        getUsers.getUsers(GetUsersObserver(), params)
    }

    override fun onDestroy() {
        view = null
        getUsers.dispose()
    }

    inner class GetUsersObserver: DisposableObserver<List<User>>() {
        override fun onComplete() {}
        override fun onNext(t: List<User>) {
            view?.onSuccessLoadUsers(t)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}