package com.example.restapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.restapi.pojo.Photo
import com.example.restapi.pojo.Post
import com.example.restapi.pojo.User
import com.example.restapi.remote.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private var photoList =  ArrayList<Photo>()
    private lateinit var viewAdapter: AdapterPhoto
   // private var userList =  ArrayList<User>()
   // private lateinit var viewAdapter: AdapterUser

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* viewAdapter = PostAdapter(postsList)
        postsRecyclerView.adapter = viewAdapter

        loadApiData()*/


        viewAdapter = AdapterPhoto(photoList)
        postsRecyclerView.adapter = viewAdapter

      //  viewAdapter = AdapterUser(userList)
       // postsRecyclerView.adapter = viewAdapter
       
        loadApiPhoto()
        //loadApiData()
    }

   /* private fun loadApiData(){
        val service=RetrofitClient.retrofitInstance()
        val call=service.getAllUsers()
        call.enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.map { userList.add(it) }
                viewAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Error: no se logro recuperar los usuarios desde la api",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }*/

    private fun loadApiPhoto() {
        val service = RetrofitClient.retrofitInstance()
        val call = service.getPhotos()

        call.enqueue(object : Callback<List<Photo>> {
            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {
                Toast.makeText(
                    applicationContext,
                    "Error: no se logro recuperar los usuarios desde la api",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                response.body()?.map { photoList.add(it) }
                viewAdapter.notifyDataSetChanged()
            }

        })
    }

}