package id.refactory.myapplication

import android.app.Application
import id.refactory.myapplication.infrastructures.di.containers.AppContainer

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        appInstance = this

        AppContainer.loadModules()
    }

    companion object {
        lateinit var appInstance: MyApplication
        fun getInstance(): MyApplication {
            return appInstance
        }
    }
}