package id.refactory.myapplication.ui.presenters

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.myapplication.ui.views.EditUserView
import org.koin.core.KoinComponent

class EditUserPresenter(var view: EditUserView.View?) : EditUserView.Presenter, KoinComponent {
    override fun onSubmitUser(path: Int, body: NewUserApiRequest) {
        TODO("Not yet implemented")
    }

    override fun onShowUser(path: Int) {
        TODO("Not yet implemented")
    }

    override fun onDeleteUser(path: Int) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}