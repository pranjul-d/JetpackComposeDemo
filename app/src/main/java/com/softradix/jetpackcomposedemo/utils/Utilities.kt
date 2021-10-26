package com.softradix.jetpackcomposedemo.utils

import android.content.Context
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softradix.jetpackcomposedemo.data.CountriesItem
import java.io.IOException
import java.lang.reflect.Type

object Utilities {
    fun generateList(context: Context): ArrayList<CountriesItem> {
        val gson = Gson()
        val type: Type = object : TypeToken<List<CountriesItem?>?>() {}.type
        return gson.fromJson(
            getJsonDataFromAsset(
                context,
                "country_listAll.json"
            ), type
        )
    }

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}

fun <T> SnapshotStateList<T>.swapList(newList: List<T>){
    clear()
    addAll(newList)
}