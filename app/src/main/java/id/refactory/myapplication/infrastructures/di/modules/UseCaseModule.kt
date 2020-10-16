package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.usecases.GetUsers
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Named

@Module
class UseCaseModule  {
    @Provides @Named("APIGetUserUseCase")
    fun provideGetUsersUseCase(@Named("APIUserRepository") userRepository: UserRepository, compositeDisposable: CompositeDisposable): GetUsers {
        return GetUsers(userRepository, compositeDisposable, AndroidSchedulers.mainThread())
    }
}