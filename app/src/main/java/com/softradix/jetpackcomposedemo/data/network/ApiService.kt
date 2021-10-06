package com.softradix.jetpackcomposedemo.data.network

import com.softradix.jetpackcomposedemo.data.Posts
import retrofit2.http.GET
import javax.inject.Singleton

interface ApiService {

    companion object{
       const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    suspend fun getPosts() : List<Posts>
}