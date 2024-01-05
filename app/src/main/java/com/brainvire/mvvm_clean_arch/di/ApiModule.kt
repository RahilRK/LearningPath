package com.brainvire.mvvm_clean_arch.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import com.brainvire.mvvm_clean_arch.data.local.PrefConstant.PREF_NAME
import com.brainvire.mvvm_clean_arch.data.local.PreferenceManager
import com.brainvire.mvvm_clean_arch.data.remote.ApiInterface
import com.brainvire.mvvm_clean_arch.data.repository_impl.LoginRepImplement
import com.brainvire.mvvm_clean_arch.data.repository_impl.RepositoryImpl
import com.brainvire.mvvm_clean_arch.domain.repository.LoginRepository
import com.brainvire.mvvm_clean_arch.domain.repository.Repository
import com.brainvire.mvvm_clean_arch.presentation.URLFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    /*
        @Provides
        @Singleton
        fun provideLoggingInterceptor(): HttpLoggingInterceptor{
            return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        }
    */

    /*
        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient{
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val builder = OkHttpClient.Builder()
            builder.addInterceptor(logging)
            builder.readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()

            return builder.build()
        }
    */

    /*
        @Provides
        @Singleton
        fun provideRetrofit(client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
    */

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }


    @Singleton
    @Provides
    fun provideLogingInterceptor(): Interceptor {
        return HttpLoggingInterceptor(/*JsonLogger()*/).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: Interceptor, preferenceManager: PreferenceManager, context: Context
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        //NOSONAR
        /*if (BuildConfig.DEBUG) {
            val chuckerInterCepter = ChuckerInterceptor.Builder(context)
                .collector(ChuckerCollector(context))
                .maxContentLength(250000L)
                .alwaysReadResponseBody(false)
                .build()
            builder.addInterceptor(chuckerInterCepter)
        }*/

        return builder.addInterceptor(
            Interceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder().method(original.method, original.body)
                builder.header("device-name", Build.MODEL)
                builder.header("device-os", "Android")
                builder.header("device-os-version", Build.VERSION.RELEASE)
                builder.header("lang", preferenceManager.getLanguage())
                builder.header("Accept", "application/json")
                if (preferenceManager.isLogin()) {
                    builder.header("Authorization", "Bearer " + preferenceManager.getAccessToken())
                }
                chain.proceed(builder.build())
            }
        )
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(120, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URLFactory.provideHttpUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    fun provideDomainRepository(apiInterface: ApiInterface): Repository {
        return RepositoryImpl(apiInterface)
    }

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun provideLoginRepository(apiInterface: ApiInterface, preferenceManager: PreferenceManager,gson: Gson): LoginRepository {
        return LoginRepImplement(apiInterface, gson)
    }

}