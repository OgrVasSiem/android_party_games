package com.ogrvassiem.partygames.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ogrvassiem.partygames.aplication.readModels.VictoryPoints
import com.ogrvassiem.partygames.data.dataStore.core.ApplicationDataStore
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class VictoryPointsDataStore(
    @ApplicationContext context: Context,
    moshi: Moshi,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApplicationDataStore<VictoryPoints>(
    context = context,
    moshi = moshi,
    key = stringPreferencesKey("victory_points_key"),
    type = VictoryPoints::class.java,
    defaultValue = VictoryPoints.TWENTY,
    dispatcher = dispatcher,
    fileName = "victory_points_prefs"
)
