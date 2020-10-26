package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.usecases.cases.GetUsers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {

    factory(named("APIGetUserUseCase")) { GetUsers(get(named("APIUserRepository")), get()) }
}