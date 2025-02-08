package com.ogrvassiem.partygames.di

import android.content.Context
import com.ogrvassiem.partygames.R
import com.ogrvassiem.partygames.aplication.readModels.TopicsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.InputStream


class JsonRepository(private val context: Context) {

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    fun readJsonFromResources(): TopicsResponse? {
        val inputStream: InputStream = context.resources.openRawResource(R.raw.alias)
        val jsonString = inputStream.bufferedReader().use { it.readText() }
        val adapter = moshi.adapter(TopicsResponse::class.java)
        return adapter.fromJson(jsonString)
    }
}