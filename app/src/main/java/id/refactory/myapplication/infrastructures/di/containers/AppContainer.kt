package id.refactory.myapplication.infrastructures.di.containers

import id.refactory.myapplication.infrastructures.di.modules.*
import org.koin.core.context.startKoin

object AppContainer {
    fun loadModules() {
        startKoin {
            modules(
                androidModule,
                apiModule,
                mapperModule,
                persistenceModule,
                repositoryModule,
                useCaseModule
            )
        }
    }
}