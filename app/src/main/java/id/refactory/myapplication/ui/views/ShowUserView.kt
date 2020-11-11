package id.refactory.myapplication.ui.views

import id.refactory.domain.NewUser

interface ShowUserView {
    interface View : BaseView<Presenter> {
        fun onSuccessLoadUser(users: NewUser)
    }

    interface Presenter : BasePresenter {
        fun onLoadUser(path: Int)
    }
}