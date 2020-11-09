package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.myapplication.infrastructures.api.NewsApi
import id.refactory.myapplication.infrastructures.api.UserApi
import id.refactory.myapplication.infrastructures.persistences.api.NewsApiPersistence
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence

@Module
class PersistenceModule {
    @Provides
    fun provideUserApiPersistence(service: UserApi): UserApiPersistence {
        return UserApiPersistence(service)
    }

    @Provides
    fun provideNewsApiPersistence(service: NewsApi): NewsApiPersistence {
        return NewsApiPersistence(service)
    }
}