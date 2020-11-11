package id.refactory.myapplication.ui.views

import id.refactory.data.payload.api.user.NewUserApiRequest
import id.refactory.domain.NewUser

interface AddUserView {
    interface View : BaseView<Presenter> {
        fun onSuccessSubmitUser(users: NewUser)
    }

    interface Presenter : BasePresenter {
        fun onSubmitUser(body: NewUserApiRequest)
    }
}