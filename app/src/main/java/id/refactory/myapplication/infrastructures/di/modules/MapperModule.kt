package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.data.persistences.mappers.NewUserDataMapper
import id.refactory.data.persistences.mappers.UserDataMapper
import org.koin.dsl.module

val mapperModule = module {

    factory { UserDataMapper() }
    factory { NewUserDataMapper() }
}