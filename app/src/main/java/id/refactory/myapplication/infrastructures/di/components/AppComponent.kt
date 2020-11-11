package id.refactory.myapplication.infrastructures.di.components

import dagger.Component
import id.refactory.myapplication.infrastructures.di.modules.*
import id.refactory.myapplication.ui.presenters.*
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidModule::class,
    ApiModule::class,
    MapperModule::class,
    PersistenceModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])

interface AppComponent {

    fun inject(mainPresenter: MainPresenter)
    fun inject(newsPresenter: NewsPresenter)
    fun inject(addPresenter: AddPresenter)
    fun inject(showPresenter: ShowPresenter)
    fun inject(editPresenter: EditPresenter)
    fun inject(deletePresenter: DeletePresenter)

    companion object {
        fun getComponent(): AppComponent {
            return DaggerAppComponent.create()
        }
    }
}