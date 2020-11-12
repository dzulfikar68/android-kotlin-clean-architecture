package id.refactory.myapplication.ui.presenters

import id.refactory.domain.NewUser
import id.refactory.myapplication.infrastructures.di.modules.Constants
import id.refactory.myapplication.ui.views.ListUserView
import id.refactory.usecases.cases.GetNewUsers
import id.refactory.usecases.infrastructures.NewUseCaseListener
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named

class ListUserPresenter(var view: ListUserView.View?) : ListUserView.Presenter, KoinComponent {
    private val getNewUsers: GetNewUsers = get(named(Constants.NEW_USER_GET_USE_CASE))

    override fun onLoadUsers(params: Map<String, String>) {
        getNewUsers.getUsers(GetNewUsersListener(), params)
    }

    override fun onDestroy() {
        view = null
        getNewUsers.cancel()
    }

    inner class GetNewUsersListener : NewUseCaseListener<List<NewUser>> {
        override fun onComplete(data: List<NewUser>) {
            view?.onSuccessLoadUsers(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }

        override fun onLoad(load: Boolean) {
            view?.onLoad(load)
        }
    }
}