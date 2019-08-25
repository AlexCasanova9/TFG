package com.uc3m.foodanalyzerbot.data.service

import android.content.Context
import android.support.v4.app.FragmentActivity
import com.google.gson.Gson
import com.google.gson.GsonBuilder

open class BasePreferencesService constructor(context: FragmentActivity) {

    private val preferences = context.getPreferences(Context.MODE_PRIVATE)

    companion object {
        private const val EMPTY_STRING = ""
    }

    protected val gson: Gson = GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create()

    protected open fun setString(key: PreferencesKey, value: String?) {
        preferences.edit().putString(key.keyString(), value).apply()
    }

    protected open fun setBoolean(key: PreferencesKey, value: Boolean?) {
        preferences.edit().putBoolean(key.keyString(), value!!).apply()
    }

    protected open fun <T> setObject(key: PreferencesKey, value: T) {
        setString(key, gson.toJson(value))
    }

    protected open fun setInt(key: PreferencesKey, value: Int) {
        preferences.edit().putInt(key.keyString(), value).apply()
    }

    protected open fun setFloat(key: PreferencesKey, value: Float) {
        preferences.edit().putFloat(key.keyString(), value).apply()
    }

    protected open fun <T> getObject(key: PreferencesKey, objectClass: Class<T>): T? {
        var result: T? = null
        val stringObject = getStringNullable(key, null)
        if (!stringObject.isNullOrBlank()) {
            result = gson.fromJson(stringObject, objectClass)
        }
        return result
    }

    protected open fun <T> getList(key: PreferencesKey, objectClass: Class<Array<T>>): List<T>? {
        var result: List<T>? = null
        val stringObject = getStringNullable(key, null)
        if (!stringObject.isNullOrBlank()) {
            result = gson.fromJson(stringObject, objectClass).toList()
        }
        return result
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    protected open fun getString(key: PreferencesKey, defValue: String = EMPTY_STRING): String {
        return getStringNullable(key, defValue) ?: EMPTY_STRING
    }

    protected open fun getStringNullable(key: PreferencesKey, defValue: String? = null): String? {
        return preferences.getString(key.keyString(), defValue)
    }

    protected open fun getBoolean(key: PreferencesKey, defValue: Boolean = false): Boolean {
        return preferences.getBoolean(key.keyString(), defValue)
    }

    protected open fun getInt(key: PreferencesKey, defValue: Int): Int {
        return preferences.getInt(key.keyString(), defValue)
    }

    protected open fun getFloat(key: PreferencesKey, defValue: Float): Float {
        return preferences.getFloat(key.keyString(), defValue)
    }

    protected open fun clear() {
        preferences.edit().clear().apply()
    }

    protected open fun clearKey(key: PreferencesKey) {
        preferences.edit().remove(key.keyString()).apply()
    }

    interface PreferencesKey {
        fun keyString(): String
    }
}