package id.refactory.myapplication.ui.views

import id.refactory.domain.NewUser

interface ShowUserView {
    interface View : BaseView<Presenter> {
        fun onSuccessLoadUser(user: NewUser)
        fun onLoading(bool: Boolean)
    }

    interface Presenter : BasePresenter {
        fun onLoadUser(path: Int)
    }
}