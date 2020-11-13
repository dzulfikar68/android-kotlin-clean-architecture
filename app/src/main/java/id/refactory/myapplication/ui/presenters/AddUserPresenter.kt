package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser
import id.refactory.myapplication.infrastructures.di.modules.Constants
import id.refactory.myapplication.ui.views.AddUserView
import id.refactory.usecases.cases.AddNewUser
import id.refactory.usecases.infrastructures.NewUseCaseListener
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.qualifier.named

class AddUserPresenter(var view: AddUserView.View?) : AddUserView.Presenter, KoinComponent {
    private val addNewUsers: AddNewUser = get(named(Constants.NEW_USER_ADD_USE_CASE))

    override fun onSubmitUser(body: NewUserApiRequest) {
        addNewUsers.addUser(AddNewUsersListener(), body)
    }

    override fun onDestroy() {
        view = null
        addNewUsers.cancel()
    }

    inner class AddNewUsersListener : NewUseCaseListener<NewUser> {
        override fun onComplete(data: NewUser) {
            view?.onSuccessSubmitUser(data)
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