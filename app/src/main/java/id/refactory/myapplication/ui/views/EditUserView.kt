package id.refactory.myapplication.ui.views

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser

interface EditUserView {
    interface View : BaseView<Presenter> {
        fun onSuccessSubmitUser(user: NewUser)
        fun onSuccessShowUser(user: NewUser)
        fun onSuccessDeleteUser(user: NewUser)
    }

    interface Presenter : BasePresenter {
        fun onSubmitUser(path: Int, body: NewUserApiRequest)
        fun onShowUser(path: Int)
        fun onDeleteUser(path: Int)
    }
}