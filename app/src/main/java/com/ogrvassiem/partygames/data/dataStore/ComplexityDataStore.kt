package com.ogrvassiem.partygames.data.dataStore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import com.ogrvassiem.partygames.aplication.readModels.Complexity
import com.ogrvassiem.partygames.data.dataStore.core.ApplicationDataStore
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ComplexityDataStore(
    @ApplicationContext context: Context,
    moshi: Moshi,
    dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ApplicationDataStore<List<Complexity>>(
    context = context,
    moshi = moshi,
    key = stringPreferencesKey("complexities_key"),
    type = Types.newParameterizedType(List::class.java, Complexity::class.java),
    defaultValue = listOf(Complexity.EASY),
    dispatcher = dispatcher,
    fileName = "complexity_prefs"
)