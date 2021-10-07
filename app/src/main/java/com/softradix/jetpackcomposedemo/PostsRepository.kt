package com.softradix.jetpackcomposedemo

import com.softradix.jetpackcomposedemo.data.Posts
import com.softradix.jetpackcomposedemo.data.network.ApiService
import com.softradix.jetpackcomposedemo.data.network.Resource
import okio.IOException
import javax.inject.Inject

class PostsRepository
@Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts(): Resource<List<Posts>> {
        Resource.Loading<List<Posts>>()
        return try {
            val response = apiService.getPosts()
            Resource.Success(data = response)

        } catch (e: IOException) {
            Resource.Failure(e)

        }

    }
}