package id.refactory.myapplication.ui.views

import id.refactory.domain.NewUser

interface ListUserView {
    interface View : BaseView<Presenter> {
        fun onSuccessLoadUsers(users: List<NewUser>)
        fun onLoad(load: Boolean)
    }

    interface Presenter : BasePresenter {
        fun onLoadUsers(params: Map<String, String>)
    }
}