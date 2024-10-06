package ke.co.banit.flowmart.core

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import ke.co.banit.flowmart.domain.models.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.shareIn
import javax.inject.Inject

/**
 * @Author: Angatia Benson
 * @Date: 10/6/2024
 * Copyright (c) 2024 BanIT
 */

val Context.dataStore by preferencesDataStore(name = "flow-mart-app")

class DataStoreManager @Inject constructor(private val context: Context) {
    companion object {
        private val IS_LOGGED_IN_KEY = booleanPreferencesKey("is_logged_in")
        private val API_KEY = stringPreferencesKey("api_key")
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USER_PHONE = stringPreferencesKey("user_phone")
        private val USER_EMAIL = stringPreferencesKey("user_email")
        private val USER_ID = intPreferencesKey("user_id")
    }

    private val dataStoreData = context.dataStore.data
        .catch { exception ->
            emit(emptyPreferences())
        }
        .shareIn(
            scope = CoroutineScope(Dispatchers.IO),
            started = SharingStarted.Eagerly,
            replay = 1
        )


    suspend fun setLoginStatus(isLoggedIn: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN_KEY] = isLoggedIn
        }
    }

    suspend fun setUser(user: User) {
        context.dataStore.edit { preferences ->
            preferences[USER_NAME] = user.name
            preferences[API_KEY] = user.apiKey
            preferences[USER_PHONE] = user.phone
            preferences[USER_EMAIL] = user.email
            preferences[USER_ID] = user.id
        }
    }

    // Read functions
    val isLoggedIn: Flow<Boolean> = dataStoreData
        .map { preferences ->
            preferences[IS_LOGGED_IN_KEY] == true
        }

    val user: Flow<User> = dataStoreData
        .map { preferences ->
            User(
                email = preferences[USER_EMAIL] ?: "",
                id = preferences[USER_ID] ?: 0,
                name = preferences[USER_NAME] ?: "",
                phone = preferences[USER_PHONE] ?: "",
                apiKey = preferences[API_KEY] ?: ""
            )
        }


    suspend fun clearUserData() {
        context.dataStore.edit { preferences ->
            preferences[IS_LOGGED_IN_KEY] = false
            preferences[API_KEY] = ""
            preferences[USER_NAME] = ""
            preferences[USER_PHONE] = ""
            preferences[USER_EMAIL] = ""
            preferences[USER_ID] = 0
        }
    }
}