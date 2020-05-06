package com.aman.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    lateinit var edtMobileNumber: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtRegister: TextView
    lateinit var txtForgotPassword: TextView
    val correctMobileNumber = "0123456789"
    val correctPassword = arrayOf("tony", "steve", "bruce", "thanos")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preferences_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        setContentView(R.layout.activity_login)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        title = "Log In"

        btnLogIn = findViewById(R.id.btnLogIn)
        edtMobileNumber = findViewById(R.id.edtMobileNumber)
        edtPassword = findViewById(R.id.edtPassword)
        txtRegister = findViewById(R.id.txtRegister)
        txtForgotPassword = findViewById(R.id.txtForgotPassWord)
        btnLogIn.setOnClickListener {

            val mobileNumber = edtMobileNumber.text.toString()
            val password = edtPassword.text.toString()
            var nameOfAvengers = "Avengers"

            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if ((correctMobileNumber == mobileNumber)) {

                if (correctPassword[0] == password) {
                    nameOfAvengers = "Iron Man"
                    savePreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (correctPassword[1] == password) {
                    nameOfAvengers = "Captain America"
                    savePreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (correctPassword[2] == password) {
                    nameOfAvengers = "The Hulk"
                    savePreferences(nameOfAvengers)
                    startActivity(intent)
                } else if (correctPassword[3] == password) {
                    nameOfAvengers = "The Avengers"
                    savePreferences(nameOfAvengers)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@LoginActivity,
                        "Invalid Credentials", Toast.LENGTH_SHORT
                    ).show()
                }

            } else {
                Toast.makeText(
                    this@LoginActivity,
                    "Invalid Credentials", Toast.LENGTH_SHORT
                ).show()
            }

        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }



    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        sharedPreferences.edit().clear().apply()
    }
}
