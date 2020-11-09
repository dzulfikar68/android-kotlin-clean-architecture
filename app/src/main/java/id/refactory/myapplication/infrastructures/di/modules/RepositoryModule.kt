package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.mappers.NewsDataMapper
import id.refactory.data.persistences.mappers.UserDataMapper
import id.refactory.data.persistences.repositories.NewsRepository
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.myapplication.infrastructures.persistences.api.NewsApiPersistence
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence
import javax.inject.Named

@Module
class RepositoryModule {
    @Provides
    @Named("APIUserRepository")
    fun provideUserApiRepository(
        persistence: UserApiPersistence,
        dataMapper: UserDataMapper
    ): UserRepository {
        return UserRepository(persistence, dataMapper)
    }

    @Provides
    @Named("APINewsRepository")
    fun provideNewsApiRepository(
        persistence: NewsApiPersistence,
        dataMapper: NewsDataMapper
    ): NewsRepository {
        return NewsRepository(persistence, dataMapper)
    }
}