package com.example.qurandemo

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rv:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv = findViewById(R.id.rv)

        val progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait")
        progressDialog.setMessage("Data Downloading...")
        progressDialog.show()


        val quran = MyService.quranService.getQuran()
            quran.enqueue(object : Callback<TopModel>{
                override fun onResponse(call: Call<TopModel>, response: Response<TopModel>) {
                    if (response.body() != null) {

                            rv.layoutManager = LinearLayoutManager(this@MainActivity)
                            rv.adapter = RVAdapter(this@MainActivity, response.body()!!.verses)
                        progressDialog.dismiss()

                    }
                }

                override fun onFailure(call: Call<TopModel>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Some Went Wrong", Toast.LENGTH_LONG).show()
                }
            })



    }
}