package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser
import id.refactory.myapplication.infrastructures.di.modules.Constants
import id.refactory.myapplication.ui.views.EditUserView
import id.refactory.usecases.cases.DeleteNewUser
import id.refactory.usecases.cases.EditNewUser
import id.refactory.usecases.cases.ShowNewUser
import id.refactory.usecases.infrastructures.NewUseCaseListener
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named

class EditUserPresenter(var view: EditUserView.View?) : EditUserView.Presenter, KoinComponent {
    private val editNewUsers: EditNewUser = get(named(Constants.NEW_USER_EDIT_USE_CASE))
    private val showNewUsers: ShowNewUser = get(named(Constants.NEW_USER_SHOW_USE_CASE))
    private val deleteNewUsers: DeleteNewUser = get(named(Constants.NEW_USER_DELETE_USE_CASE))

    override fun onSubmitUser(path: Int, body: NewUserApiRequest) {
        editNewUsers.editUser(EditNewUsersListener(), path, body)
    }

    override fun onShowUser(path: Int) {
        showNewUsers.showUser(ShowNewUsersListener(), path)
    }

    override fun onDeleteUser(path: Int) {
        deleteNewUsers.deleteUser(DeleteNewUsersListener(), path)
    }

    override fun onDestroy() {
        view = null
        editNewUsers.cancel()
    }

    inner class DeleteNewUsersListener : NewUseCaseListener<NewUser> {
        override fun onComplete(data: NewUser) {
            view?.onSuccessDeleteUser(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }

        override fun onLoad(load: Boolean) {
        }
    }

    inner class ShowNewUsersListener : NewUseCaseListener<NewUser> {
        override fun onComplete(data: NewUser) {
            view?.onSuccessShowUser(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }

        override fun onLoad(load: Boolean) {
        }
    }

    inner class EditNewUsersListener : NewUseCaseListener<NewUser> {
        override fun onComplete(data: NewUser) {
            view?.onSuccessSubmitUser(data)
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
            view?.onError()
        }

        override fun onLoad(load: Boolean) {
        }
    }
}