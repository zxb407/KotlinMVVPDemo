package com.jjshouse.kotlinmvvpdemo.utils

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor;
import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.base.constants.Key

object SPUtils {
    fun putLong(key: String , value: Long) {
        var editor: Editor = getSPEditor()
        editor.putLong(key, value)
        editor.commit()
    }

    private fun getSPEditor(): Editor {
        return JJApplication.instance.getSharedPreferences(Key.SP_NAME, 0).edit()
    }
    
    private fun getSharedPreferences(): SharedPreferences {
        return JJApplication.instance.getSharedPreferences(Key.SP_NAME, 0)
    }
    fun getLong(key: String): Long {
        return getSharedPreferences().getLong(key, -1)
    }

    fun putString(key: String, value:String) {
        var editor: Editor = getSPEditor()
        editor.putString(key, value)
        editor.commit()
    }

    fun getString(key: String): String {
        return getSharedPreferences().getString(key, "").toString()
    }

    fun putInt(key: String, value: Int) {
        var editor: Editor = getSPEditor()
        editor.putInt(key, value)
        editor.commit()
    }

    fun getInt(key: String): Int {
        return getSharedPreferences().getInt(key, -1)
    }

    fun getBoolean(key: String): Boolean {
        return getSharedPreferences().getBoolean(key, false)
    }

    fun putBoolean(key: String, value: Boolean) {
        var editor: Editor = getSPEditor()
        editor.putBoolean(key, value);
        editor.commit();
    }

    fun getUserInfo(): String {
        var email: String = getString(Key.USER_EMAIL)
        return "{\"email\":\"" + email + "\",\"password\":\"" + getString(Key.USER_PASSWORD) + "\"}"
    }
}
