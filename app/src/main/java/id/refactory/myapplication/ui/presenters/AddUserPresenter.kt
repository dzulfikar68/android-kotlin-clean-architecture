package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.myapplication.ui.views.AddUserView
import org.koin.core.KoinComponent

class AddUserPresenter(var view: AddUserView.View?) : AddUserView.Presenter, KoinComponent {
    override fun onSubmitUser(body: NewUserApiRequest) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}