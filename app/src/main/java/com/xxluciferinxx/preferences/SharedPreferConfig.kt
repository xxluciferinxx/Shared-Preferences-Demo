package com.xxluciferinxx.preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferConfig(
    private val ctx: Context,
) {
    private val sharedPreferences: SharedPreferences
        get() = ctx.getSharedPreferences(
            ctx.resources.getString(R.string.app_name), Context.MODE_PRIVATE
        )

    fun writePref(state: Boolean) {
        sharedPreferences.edit().apply {
            putBoolean(ctx.resources.getString(R.string.app_name), state)
        }.apply()
    }

    fun readPref(): Boolean {
        return sharedPreferences.getBoolean(ctx.resources.getString(R.string.app_name), false)
    }
}