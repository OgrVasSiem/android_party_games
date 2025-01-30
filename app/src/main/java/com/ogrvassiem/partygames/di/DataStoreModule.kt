package com.ogrvassiem.partygames.di

import android.content.Context
import com.ogrvassiem.partygames.data.dataStore.ShowOnboardingDataStore
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataStoreModule {
    @Singleton
    @Provides
    fun provideShowOnboardingDataStore(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): ShowOnboardingDataStore {
        return ShowOnboardingDataStore(
            context = context,
            moshi = moshi
        )
    }
}