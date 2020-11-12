package id.refactory.myapplication.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.refactory.domain.NewUser
import id.refactory.myapplication.R
import id.refactory.myapplication.ui.views.AddUserView

class AddUserActivity : AppCompatActivity(), AddUserView.View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_user)
    }

    override fun onSuccessSubmitUser(users: NewUser) {
        TODO("Not yet implemented")
    }

    override fun onLoad(load: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onPrepare() {
        TODO("Not yet implemented")
    }

    override fun onError() {
        TODO("Not yet implemented")
    }
}