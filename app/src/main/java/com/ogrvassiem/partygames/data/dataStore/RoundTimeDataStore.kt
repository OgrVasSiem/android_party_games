package com.ogrvassiem.partygames.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ogrvassiem.partygames.aplication.readModels.RoundTime
import com.ogrvassiem.partygames.data.dataStore.core.ApplicationDataStore
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class RoundTimeDataStore(
    @ApplicationContext context: Context,
    moshi: Moshi,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApplicationDataStore<RoundTime>(
    context = context,
    moshi = moshi,
    key = stringPreferencesKey("round_time_key"),
    type = RoundTime::class.java,
    defaultValue = RoundTime.TWENTY,
    dispatcher = dispatcher,
    fileName = "round_time_prefs"
)
