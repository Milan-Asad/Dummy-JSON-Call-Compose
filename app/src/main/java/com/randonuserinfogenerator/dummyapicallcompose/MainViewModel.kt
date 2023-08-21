package com.randonuserinfogenerator.dummyapicallcompose

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.randonuserinfogenerator.dummyapicallcompose.MyData.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//class MainViewModel : ViewModel() {
//
//    private val api = Retrofit.Builder()
//        .baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(APIinterface::class.java)
//
//    private val _data = MutableLiveData<List<MyDataItem>>()
//    val data: LiveData<List<MyDataItem>> = _data
//
//    private var isDataFetched = false
//
//    suspend fun fetchDataIfNeeded() {
//        if (!isDataFetched) {
//            try {
//                val response = api.getData()
//                if (response.isNotEmpty()) {
//                    _data.postValue(response)
//                } else {
//                    // Handle error here, e.g., show an error message
//                }
//            } catch (e: Exception) {
//                // Handle failure here
//            }
//            isDataFetched = true
//        }
//    }
//}


