package com.ogrvassiem.partygames.aplication.query.operations

import com.ogrvassiem.partygames.aplication.query.core.Query
import com.ogrvassiem.partygames.aplication.query.core.QueryHandler
import com.ogrvassiem.partygames.data.dataStore.ShowOnboardingDataStore
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data object GetShowOnboardingQuery : Query<Boolean>

class GetShowOnboardingQueryHandler @Inject constructor(
    private val showOnboardingDataStore: ShowOnboardingDataStore
) : QueryHandler<GetShowOnboardingQuery, Boolean> {

    override fun handle(query: GetShowOnboardingQuery): Flow<Boolean> {
        return showOnboardingDataStore.data
    }
}
