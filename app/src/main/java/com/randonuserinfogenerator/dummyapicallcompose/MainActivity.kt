package com.randonuserinfogenerator.dummyapicallcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randonuserinfogenerator.dummyapicallcompose.MyData.MyDataItem
import com.randonuserinfogenerator.dummyapicallcompose.ui.theme.DummyAPICallComposeTheme
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// https://jsonplaceholder.typicode.com/posts - Main Link

// BASE URL
const val BASE_URL = "https://jsonplaceholder.typicode.com/"


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DummyAPICallComposeTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, end = 15.dp),


                    color = MaterialTheme.colorScheme.background
                ) {

                    // RECALLING THE FUNCTION (SIMILAR CONCEPT OUTSIDE OF COMPOSE)
                    FetchDataAndDisplay()
                }
            }
        }
    }
}


@Composable
fun FetchDataAndDisplay() {

    // REMEMBERS + HOLD THE DATA
    var data by remember { mutableStateOf<List<MyDataItem>>(emptyList()) }

    // RETROFIT BUILDER
    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    // CONNECTING WITH API CLASS (GET REQUEST)
    val api = retrofit.create(APIinterface::class.java)

    // FETCH DATA USING LAUNCHED EFFECT (USED FOR COMPOSE)
    LaunchedEffect(true) {

        // TRY CATCH ETC
        try {
            val response = api.getData() // CALLING API
            data = response
        } catch (e: Exception) {

            // EMPTY TO SHOW DATA
            data = emptyList()
        }
    }

    // DISPLAYING JSON DATA
    Column {

        for (item in data) {

            Column(
                modifier = Modifier) {

            }

            // JSON DATA CLASS STUFF
            Text("User ID: ${item.userId}")


            Text("Title: ${item.title}")
            Text("Body: ${item.body}")
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}

// PREVIEW
@Preview(showBackground = true)
@Composable
fun FetchDataAndDisplayPreview() {
    DummyAPICallComposeTheme {
        FetchDataAndDisplay()
    }
}
