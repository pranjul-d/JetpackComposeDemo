package com.softradix.jetpackcomposedemo.di

import android.content.Context
import com.softradix.jetpackcomposedemo.application.PostApplication
import com.softradix.jetpackcomposedemo.database.dao.UserDao
import com.softradix.jetpackcomposedemo.repositories.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): PostApplication {
        return app as PostApplication
    }


    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao) = UserRepository(userDao)

}