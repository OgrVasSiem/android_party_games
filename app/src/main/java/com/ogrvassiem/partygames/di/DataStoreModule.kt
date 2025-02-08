package com.ogrvassiem.partygames.di

import android.content.Context
import com.ogrvassiem.partygames.data.dataStore.ComplexityDataStore
import com.ogrvassiem.partygames.data.dataStore.PenaltyForSkippingDataStore
import com.ogrvassiem.partygames.data.dataStore.RoundTimeDataStore
import com.ogrvassiem.partygames.data.dataStore.ShowOnboardingDataStore
import com.ogrvassiem.partygames.data.dataStore.VictoryPointsDataStore
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

    @Singleton
    @Provides
    fun provideComplexityDataStore(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): ComplexityDataStore {
        return ComplexityDataStore(
            context = context,
            moshi = moshi
        )
    }

    @Singleton
    @Provides
    fun provideVictoryPointsDataStore(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): VictoryPointsDataStore {
        return VictoryPointsDataStore(
            context = context,
            moshi = moshi
        )
    }

    @Singleton
    @Provides
    fun provideRoundTimeDataStore(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): RoundTimeDataStore {
        return RoundTimeDataStore(
            context = context,
            moshi = moshi
        )
    }

    @Singleton
    @Provides
    fun providePenaltyForSkippingDataStore(
        @ApplicationContext context: Context,
        moshi: Moshi
    ): PenaltyForSkippingDataStore {
        return PenaltyForSkippingDataStore(
            context = context,
            moshi = moshi
        )
    }
}