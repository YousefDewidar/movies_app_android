package com.yousef.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yousef.moviesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = resources.getColor(R.color.primary)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Send user name to home screen and validate
        binding.buttLogin.setOnClickListener {
            val userName: String = binding.editTextName.text.toString()
            val pass: String = binding.editTextPass.text.toString()

            if (userName != "" && pass != "" && pass.length >= 8) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(Constant.name, userName)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "User name and password are wrong", Toast.LENGTH_SHORT)
                    .show()
            }

        }

    }
}