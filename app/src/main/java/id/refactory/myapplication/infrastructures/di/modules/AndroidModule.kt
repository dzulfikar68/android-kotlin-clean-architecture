package id.refactory.myapplication.infrastructures.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import id.refactory.myapplication.MyApplication
import kotlinx.coroutines.asCoroutineDispatcher
import java.util.concurrent.Executors
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
class AndroidModule {
    @Provides
    fun provideContext(): Context {
        return MyApplication.getInstance().applicationContext
    }

    @Provides @Singleton
    fun provideCoroutineContext(): CoroutineContext {
        return Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    }
}