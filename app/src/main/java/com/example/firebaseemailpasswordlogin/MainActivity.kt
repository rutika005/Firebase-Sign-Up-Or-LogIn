package com.example.firebaseemailpasswordlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseemailpasswordlogin.databinding.ActivityMainBinding
import com.example.firebaseemailpasswordlogin.databinding.ActivitySignUpBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnsignup.setOnClickListener{
            val i = Intent(this,SignUp::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener{
            val i = Intent(this,Login::class.java)
            startActivity(i)
        }

    }
}