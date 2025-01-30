package com.ogrvassiem.partygames.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ogrvassiem.partygames.data.dataStore.core.ApplicationDataStore
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ShowOnboardingDataStore(
    @ApplicationContext private val context: Context,
    moshi: Moshi,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApplicationDataStore<Boolean>(
    context = context,
    moshi = moshi,
    key = stringPreferencesKey("show_onboarding_key"),
    type = Boolean::class.java,
    defaultValue = true,
    dispatcher = dispatcher,
    fileName = "show_onboarding_prefs"
)