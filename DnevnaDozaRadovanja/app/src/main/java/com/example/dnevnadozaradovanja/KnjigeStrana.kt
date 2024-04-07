package com.example.dnevnadozaradovanja

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import retrofit2.Call
import retrofit2.Callback
import android.util.Log
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class KnjigeStrana : AppCompatActivity() {

    lateinit var myAdapter1: MyAdapter
    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var recyclerview_users: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.knjige)

        recyclerview_users = findViewById(R.id.recyclerview_users)

        recyclerview_users.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        recyclerview_users.layoutManager = linearLayoutManager

        myAdapter1 = MyAdapter(baseContext, emptyList())
        recyclerview_users.adapter = myAdapter1

        getMyData();

        val drugaStrana = findViewById<FloatingActionButton>(R.id.fab)
        drugaStrana.setOnClickListener{
            val Intent = Intent(this, DrugaStrana::class.java)
            startActivity(Intent)
        }
    }

    private fun getMyData() {

        val BASE_URL:String = "https://api.jsonserve.com/"

        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {
                val responseBody = response.body()!!

                myAdapter1.setData(responseBody)

                myAdapter1 = MyAdapter(baseContext, responseBody)
                myAdapter1.notifyDataSetChanged()
                recyclerview_users.adapter = myAdapter1
            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Log.e("KnjigeStrana", "onFailure" + t.message)
            }
        })
    }
}