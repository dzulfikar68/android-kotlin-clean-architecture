package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.data.persistences.repositories.UserRepository
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {

    factory(named("APIUserRepository")) {
        UserRepository(get<UserApiPersistence>(), get())
    }
}