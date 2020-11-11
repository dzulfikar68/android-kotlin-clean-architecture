package id.refactory.myapplication.ui.presenters

import id.refactory.myapplication.ui.views.ListUserView
import org.koin.core.KoinComponent

class ListUserPresenter(var view: ListUserView.View?) : ListUserView.Presenter, KoinComponent {
    override fun onLoadUsers(params: Map<String, String>) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}