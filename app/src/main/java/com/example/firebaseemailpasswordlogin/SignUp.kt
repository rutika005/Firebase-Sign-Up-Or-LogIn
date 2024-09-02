package com.example.firebaseemailpasswordlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseemailpasswordlogin.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

private val Any.exception: Any
    get() {
        TODO("Not yet implemented")
    }

private val Any.isSuccessful: Boolean
    get() {
        TODO("Not yet implemented")
    }

class SignUp : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textlogin.setOnClickListener{
            val i = Intent(this,Login::class.java)
            startActivity(i)
        }
        binding.btnsign.setOnClickListener{
            val email = binding.semail.text.toString()
            val pass = binding.spassword.text.toString()
            val confirmPass = binding.confirpassword.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email,pass).addOnCanceledListener{
                        if (it.isSuccessful){
                            val i =  Intent(this,SignUp::class.java)
                            startActivity(i)
                        }
                        else{
                            Toast.makeText(this,it.exception.toString(),Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()

                }
            }else{
                Toast.makeText(this,"Empty Fields Are not Allowed !!",Toast.LENGTH_SHORT).show()
            }
        }

    }
}