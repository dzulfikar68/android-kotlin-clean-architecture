package id.refactory.myapplication.ui.presenters

import id.refactory.domain.User
import id.refactory.myapplication.infrastructures.di.components.AppComponent
import id.refactory.myapplication.ui.views.MainView
import id.refactory.usecases.cases.GetUsers
import id.refactory.usecases.infrastructures.UseCaseListener
import javax.inject.Inject
import javax.inject.Named

class MainPresenter (var view: MainView.View?): MainView.Presenter {
    @Inject @Named("APIGetUserUseCase") lateinit var getUsers: GetUsers

    init {
        AppComponent.getComponent().inject(this)
    }

    override fun onLoadUsers(params: Map<String, String>) {
        getUsers.getUsers(GetUsersListener(), params)
    }

    override fun onDestroy() {
        view = null
        getUsers.cancel()
    }

    inner class GetUsersListener: UseCaseListener<List<User>> {
        override fun onComplete(data: List<User>) {
            view?.onSuccessLoadUsers(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }
    }
}