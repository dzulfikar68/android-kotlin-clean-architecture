package id.refactory.myapplication.infrastructures.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import id.refactory.myapplication.infrastructures.api.NewUserApi
import id.refactory.myapplication.infrastructures.api.UserApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val apiModule = module {

    factory {
        GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create()
    }

    factory<Retrofit> {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        Retrofit.Builder()
//        https://my-json-server.typicode.com/glendmaatita/userjsondemo
            .baseUrl("https://gorest.co.in/")
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(client)
            .build()
    }

    factory<UserApi> { get<Retrofit>().create(UserApi::class.java) }
    factory<NewUserApi> { get<Retrofit>().create(NewUserApi::class.java) }
}