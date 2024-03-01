package com.example.compose_introducao.datastore

import androidx.datastore.preferences.core.booleanPreferencesKey

object AppDataStoreKeys {
    val AUTENTICADO = booleanPreferencesKey("autenticado")
}