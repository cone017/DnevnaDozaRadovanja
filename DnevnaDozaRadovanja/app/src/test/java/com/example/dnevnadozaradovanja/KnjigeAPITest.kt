package com.example.dnevnadozaradovanja

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KnjigeAPITest {

    lateinit var mockWebServer: MockWebServer
    lateinit var apiInterface: ApiInterface

    @Before
    fun setup(){
        mockWebServer = MockWebServer()
        apiInterface = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiInterface::class.java)
    }

    @Test
    fun testGetData(){

        val mockResponse = MockResponse()
        mockResponse.setBody("[]")
        mockWebServer.enqueue(mockResponse)

        val response = apiInterface.getData().execute()

        // Check if the request was successful
        Assert.assertTrue(response.isSuccessful)

        // Check if the response body is not null
        val responseBody = response.body()
        Assert.assertNotNull(responseBody)

        // Check if the response body is empty
        Assert.assertTrue(responseBody!!.isEmpty())
    }

    @After
    fun tearDown(){
        mockWebServer.shutdown()
    }
}