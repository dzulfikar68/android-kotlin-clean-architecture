package id.refactory.myapplication.infrastructures.di.modules

import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_ADD_USE_CASE
import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_DELETE_USE_CASE
import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_EDIT_USE_CASE
import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_GET_USE_CASE
import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_REPO
import id.refactory.myapplication.infrastructures.di.modules.Constants.NEW_USER_SHOW_USE_CASE
import id.refactory.usecases.cases.GetUsers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val useCaseModule = module {

    //user
    factory(named("APIGetUserUseCase")) { GetUsers(get(named("APIUserRepository")), get()) }

    //new user
    factory(named(NEW_USER_GET_USE_CASE)) { GetUsers(get(named(NEW_USER_REPO)), get()) }
    factory(named(NEW_USER_SHOW_USE_CASE)) { GetUsers(get(named(NEW_USER_REPO)), get()) }
    factory(named(NEW_USER_ADD_USE_CASE)) { GetUsers(get(named(NEW_USER_REPO)), get()) }
    factory(named(NEW_USER_EDIT_USE_CASE)) { GetUsers(get(named(NEW_USER_REPO)), get()) }
    factory(named(NEW_USER_DELETE_USE_CASE)) { GetUsers(get(named(NEW_USER_REPO)), get()) }
}