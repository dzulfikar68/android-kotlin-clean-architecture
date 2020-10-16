package id.refactory.myapplication.infrastructures.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import id.refactory.myapplication.MyApplication

@Module
class AndroidModule {
    @Provides
    fun provideContext(): Context {
        return MyApplication.getInstance().applicationContext
    }
}