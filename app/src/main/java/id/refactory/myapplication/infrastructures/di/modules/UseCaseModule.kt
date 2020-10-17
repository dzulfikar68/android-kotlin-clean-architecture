package id.refactory.myapplication.infrastructures.di.modules

import dagger.Module
import dagger.Provides
import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.usecases.cases.GetUsers
import javax.inject.Named
import kotlin.coroutines.CoroutineContext

@Module
class UseCaseModule  {
    @Provides @Named("APIGetUserUseCase")
    fun provideGetUsersUseCase(@Named("APIUserRepository") userRepository: UserRepository, context: CoroutineContext): GetUsers {
        return GetUsers(userRepository, context)
    }
}