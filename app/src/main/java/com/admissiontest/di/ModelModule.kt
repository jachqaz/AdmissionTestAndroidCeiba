package com.admissiontest.di


import com.admissiontest.domain.model.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ModelModule {

    @Singleton
    @Provides
    fun provideAddress() = Address()

    @Singleton
    @Provides
    fun provideCompany() = Company()

    @Singleton
    @Provides
    fun provideGeo() = Geo()

    @Singleton
    @Provides
    fun providePost() = Post()

    @Singleton
    @Provides
    fun provideUser() = User()

}
