package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.repositories.NewsRepository
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.usecases.GetNews
import id.refactory.usecases.GetUsers
import id.refactory.usecases.PostNews
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

@Module
class UseCaseModule {
    @Provides
    @Named("APIGetUserUseCase")
    fun provideGetUsersUseCase(
        @Named("APIUserRepository") userRepository: UserRepository,
        compositeDisposable: CompositeDisposable
    ): GetUsers {
        return GetUsers(userRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }

    @Provides
    @Named("APIPostNewsUseCase")
    fun providePostNewsUseCase(
        @Named("APINewsRepository") newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): PostNews {
        return PostNews(newsRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }

    @Provides
    @Named("APIGetNewsUseCase")
    fun provideGetNewsUseCase(
        @Named("APINewsRepository") newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): GetNews {
        return GetNews(newsRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }
}