package com.ogrvassiem.partygames.di

import com.ogrvassiem.partygames.aplication.query.core.Query
import com.ogrvassiem.partygames.aplication.query.core.QueryHandler
import com.ogrvassiem.partygames.aplication.query.operations.GetShowOnboardingQuery
import com.ogrvassiem.partygames.aplication.query.operations.GetShowOnboardingQueryHandler
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
@InstallIn(SingletonComponent::class)
abstract class QueriesModule {
    @MapKey
    annotation class QueryHandlerKey(val value: KClass<out Query<*>>)

    @Binds
    @IntoMap
    @QueryHandlerKey(GetShowOnboardingQuery::class)
    abstract fun bindGetShowOnboardingQueryHandler(
        handler: GetShowOnboardingQueryHandler
    ): QueryHandler<*, *>
}