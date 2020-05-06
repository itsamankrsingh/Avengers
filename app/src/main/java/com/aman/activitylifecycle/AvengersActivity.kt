package com.aman.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {

    var titleName: String?="The Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preferences_file_name),Context.MODE_PRIVATE)


        setContentView(R.layout.activity_avengers)

        titleName=sharedPreferences.getString("Title","The Avengers")


        title=titleName
    }


}
