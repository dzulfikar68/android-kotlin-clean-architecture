package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.myapplication.infrastructures.persistences.api.NewUserApiPersistence
import id.refactory.myapplication.infrastructures.persistences.api.UserApiPersistence
import org.koin.dsl.module

val persistenceModule = module {

    factory { UserApiPersistence(get()) }
    factory { NewUserApiPersistence(get()) }
}