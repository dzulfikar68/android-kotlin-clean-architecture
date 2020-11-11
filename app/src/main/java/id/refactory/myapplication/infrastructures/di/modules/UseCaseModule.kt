package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.repositories.NewsRepository
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.usecases.*
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

    @Provides
    @Named("APIShowNewsUseCase")
    fun provideShowNewsUseCase(
        @Named("APINewsRepository") newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): ShowNews {
        return ShowNews(newsRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }

    @Provides
    @Named("APIPutNewsUseCase")
    fun providePutNewsUseCase(
        @Named("APINewsRepository") newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): PutNews {
        return PutNews(newsRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }

    @Provides
    @Named("APIDeleteNewsUseCase")
    fun provideDeleteNewsUseCase(
        @Named("APINewsRepository") newsRepository: NewsRepository,
        compositeDisposable: CompositeDisposable
    ): DeleteNews {
        return DeleteNews(newsRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }
}