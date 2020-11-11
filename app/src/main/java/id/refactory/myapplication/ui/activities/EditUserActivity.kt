package id.refactory.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.views.EditUserView

class EditUserActivity : AppCompatActivity(), EditUserView.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_user)
    }

    override fun onSuccessSubmitUser(users: NewUser) {
        TODO("Not yet implemented")
    }

    override fun onSuccessShowUser(users: NewUser) {
        TODO("Not yet implemented")
    }

    override fun onSuccessDeleteUser(users: NewUser) {
        TODO("Not yet implemented")
    }

    override fun onPrepare() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
}