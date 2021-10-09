package com.softradix.jetpackcomposedemo.di

import android.content.Context
import androidx.room.Room
import com.softradix.jetpackcomposedemo.database.AppDatabase
import com.softradix.jetpackcomposedemo.database.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao{
        return  appDatabase.userDao()
    }

    @Provides
    fun provideDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context,
            AppDatabase::class.java,
        "user.db"
    ).allowMainThreadQueries().build()

}