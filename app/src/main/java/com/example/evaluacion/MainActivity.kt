package com.example.evaluacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluacion.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private var binding:ActivityMainBinding? = null
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        auth = Firebase.auth

        binding?.btnSignOut?.setOnClickListener {
            if (auth.currentUser!= null)
            {
                auth.signOut()
                startActivity(Intent(this,GetStartedActivity::class.java))
                finish()
            }

            val auth = Firebase.auth
            if (auth.currentUser!= null)
                startActivity(Intent(this,MainActivity::class.java))
            finish()
            }
    }
}