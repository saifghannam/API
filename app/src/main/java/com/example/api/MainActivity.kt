package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.api.model.Remot.ServesAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView=findViewById(R.id.textAPI)
        val setdata = SetData("CODEING KOTLEN ", "saifghannam ", 1)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val servesAPI = retrofit.create(ServesAPI::class.java)


        val call: Call<PostData> = servesAPI.setPost(setdata)
        call.enqueue(object : Callback<PostData> {


            override fun onResponse(call: Call<PostData>, response: Response<PostData>) {

                if (response.isSuccessful) {
                    val postData: PostData? = response.body()
                    if (postData != null && postData.title != null) {
                        textView.text = postData.title
                    } else {
                        textView.text = "First Name not available"
                    }
                } else {
                    textView.text = "Response not successful"
                }            }


            override fun onFailure(call: Call<PostData>, t: Throwable) {
                textView.setText(t.message)
            }

        })






    }
}




