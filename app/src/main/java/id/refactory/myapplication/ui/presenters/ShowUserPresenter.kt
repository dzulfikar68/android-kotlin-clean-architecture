package id.refactory.myapplication.ui.presenters

import id.refactory.myapplication.ui.views.ShowUserView
import org.koin.core.KoinComponent

class ShowUserPresenter(var view: ShowUserView.View?) : ShowUserView.Presenter, KoinComponent {
    override fun onLoadUser(path: Int) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }
}