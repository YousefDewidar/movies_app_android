package com.yousef.moviesapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yousef.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.primary)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Send user name to home screen and validate
        binding.buttLogin.setOnClickListener {
            val userName: String = binding.editTextName.text.toString()
            val pass: String = binding.editTextPass.text.toString()

            if (userName != "" && pass != "") {
                if(pass.length >= 8){
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.putExtra(Constant.name, userName)
                    startActivity(intent)
                    finish()
                }else {
                    binding.passValidateA.setTextColor(R.color.grey)
                }

            } else {
                Toast.makeText(this, "User name and password are wrong", Toast.LENGTH_SHORT)
                    .show()
            }

        }

    }
}