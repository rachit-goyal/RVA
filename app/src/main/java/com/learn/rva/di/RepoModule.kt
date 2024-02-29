package com.learn.rva.di

import com.learn.rva.data.repository.RepositoryImpl
import com.learn.rva.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
created by Rachit on 2/27/2024.
 */

@InstallIn(SingletonComponent::class)
@Module
abstract class RepoModule {

   @Binds
   @Singleton
   abstract fun bindsRepository(repositoryImpl: RepositoryImpl): MainRepository
}