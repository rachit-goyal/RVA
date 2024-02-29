package com.learn.rva.di

import com.learn.rva.data.Service.ValidateUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
created by Rachit on 2/27/2024.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getService():ValidateUser{
        return ValidateUser()
    }

}