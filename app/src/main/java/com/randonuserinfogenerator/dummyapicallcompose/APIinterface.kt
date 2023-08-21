package com.randonuserinfogenerator.dummyapicallcompose

import com.randonuserinfogenerator.dummyapicallcompose.MyData.MyDataItem
import retrofit2.Call
import retrofit2.http.GET

// https://jsonplaceholder.typicode.com/posts

interface APIinterface {

    @GET("posts")
    suspend fun getData(): List<MyDataItem>
}
