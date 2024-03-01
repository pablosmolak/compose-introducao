package com.example.compose_introducao.datastore

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(SETTINGS)
class AppDataStore @Inject constructor(
    var dataStore: DataStore<Preferences>
){
    suspend fun putBollean(key:Preferences.Key<Boolean>,value: Boolean){
        dataStore.edit {
            preferences -> preferences[key] = value
        }
    }

    fun getBoolean(key: Preferences.Key<Boolean>) : Flow<Boolean>{
        return dataStore.data.map {
            preferences -> preferences[key] ?: false
        }
    }

}