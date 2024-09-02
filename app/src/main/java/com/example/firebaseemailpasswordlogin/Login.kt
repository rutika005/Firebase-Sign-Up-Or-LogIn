package com.example.firebaseemailpasswordlogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firebaseemailpasswordlogin.databinding.ActivityLoginBinding
import com.example.firebaseemailpasswordlogin.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.lang.Exception
private val Any.exception: Any
    get() {
        TODO("Not yet implemented")
    }

private val Any.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }

class Login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txtsignup.setOnClickListener{
            val i = Intent(this,SignUp::class.java)
            startActivity(i)
        }
        binding.Login.setOnClickListener{
            val email = binding.lemail.text.toString()
            val pass = binding.lpassword.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()){

                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCanceledListener{
                        if (it.isSuccessful){
                            val i =  Intent(this,MainActivity::class.java)
                            startActivity(i)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

            }else{
                Toast.makeText(this,"Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}