package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.myapplication.MyApplication
import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.dsl.module
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

val androidModule = module {
    factory { MyApplication.getInstance().applicationContext }
    single<CoroutineContext> { Executors.newSingleThreadExecutor().asCoroutineDispatcher() }
}