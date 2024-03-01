package com.example.compose_introducao.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.datastore.preferences.core.Preferences
import dagger.Provides
import javax.inject.Singleton


const val SETTINGS = "settings"
@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Provides
    @Singleton
    fun providePreferencesDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences>{
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile(SETTINGS)}
        )
    }

}