package com.yousef.moviesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.StrikethroughSpan
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

        listenPasswordFun()

        //  Send user name to home screen and validate
        binding.buttLogin.setOnClickListener {
            val userName: String = binding.editTextName.text.toString()
            val pass: String = binding.editTextPass.text.toString()

            val hasLetters =
                pass.matches(".*[a-zA-Z].*".toRegex())
            val hasDigits = pass.matches(".*\\d.*".toRegex())
            if (userName != "" && pass != "" && pass.length >= 8 && hasDigits && hasLetters) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra(Constant.name, userName)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, "User name or password are wrong", Toast.LENGTH_SHORT)
                    .show()
            }

        }


    }

    //    this function to handle validate password
    private fun listenPasswordFun() {
        binding.editTextPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (!charSequence.isNullOrEmpty()) {
                    val password = charSequence.toString()
                    val validateA = binding.passValidateA
                    val validateB = binding.passValidateB
                    if (binding.editTextPass.text.length >= 8) {
//                      To add throw line when text length >= 8
                        val spannable = SpannableString(validateA.text)
                        spannable.setSpan(
                            StrikethroughSpan(),
                            0,
                            validateA.text.length,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        validateA.text = spannable
                    } else {
                        validateA.text =
                            getString(R.string.password_must_be_at_least_8_characters_long)
                    }

//                    To check pass contain numbers & letters
                    val hasLetters =
                        password.matches(".*[a-zA-Z].*".toRegex())
                    val hasDigits = password.matches(".*\\d.*".toRegex())

                    if (hasLetters && hasDigits) {
                        val spannable = SpannableString(validateB.text)
                        spannable.setSpan(
                            StrikethroughSpan(),
                            0,
                            validateB.text.length,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                        )
                        validateB.text = spannable
                    } else {
                        validateB.text =
                            getString(R.string.password_must_contain_numbers_and_characters)
                    }

                }
            }

            override fun afterTextChanged(editable: Editable?) {}
        })
    }

}