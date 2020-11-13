package id.refactory.myapplication.ui.presenters

import id.refactory.domain.NewUser
import id.refactory.myapplication.infrastructures.di.modules.Constants
import id.refactory.myapplication.ui.views.ShowUserView
import id.refactory.usecases.cases.ShowNewUser
import id.refactory.usecases.infrastructures.NewUseCaseListener
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named

class ShowUserPresenter(var view: ShowUserView.View?) : ShowUserView.Presenter, KoinComponent {
    private val showNewUsers: ShowNewUser = get(named(Constants.NEW_USER_SHOW_USE_CASE))
    override fun onLoadUser(path: Int) {
        showNewUsers.showUser(ShowNewUsersListener(), path)
    }

    override fun onDestroy() {
        view = null
        showNewUsers.cancel()
    }

    inner class ShowNewUsersListener : NewUseCaseListener<NewUser> {
        override fun onComplete(data: NewUser) {
            view?.onSuccessLoadUser(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }

        override fun onLoad(load: Boolean) {
            view?.onLoading(load)
        }
    }
}