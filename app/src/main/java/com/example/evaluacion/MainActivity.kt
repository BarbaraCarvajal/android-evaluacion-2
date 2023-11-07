package com.example.evaluacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var btnSignOut: Button
    private lateinit var tvCrearIdeas: TextView
    private lateinit var tvVerIdeas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando FirebaseAuth
        auth = Firebase.auth

        // Vinculando vistas usando findViewById
        btnSignOut = findViewById(R.id.btnSignOut)
        tvCrearIdeas = findViewById(R.id.crearIdeas)
        tvVerIdeas = findViewById(R.id.verIdeas)


        // OnClickListener para el botón de cerrar sesión
        btnSignOut.setOnClickListener {
            // Chequea si el usuario actual está logueado
            if (auth.currentUser != null) {
                auth.signOut()
                startActivity(Intent(this, GetStartedActivity::class.java))
                finish()
            }
        }

        // OnClickListener para "Nueva idea"
        tvCrearIdeas.setOnClickListener {
            // Inicia NuevaIdeaActivity
            startActivity(Intent(this, NuevaIdea::class.java))
        }

        // OnClickListener para "Ver mis ideas"
        tvVerIdeas.setOnClickListener {
            // Inicia ViewIdeasActivity
            startActivity(Intent(this, ViewIdeasActivity::class.java))
        }

        btnSignOut.setOnClickListener {
            Log.d("MainActivity", "Sign out button pressed.")
            if (auth.currentUser != null) {
                Log.d("MainActivity", "Current user is not null, proceeding with sign out.")
                auth.signOut()
                startActivity(Intent(this, GetStartedActivity::class.java))
                finish()
            } else {
                Log.d("MainActivity", "No user is currently signed in.")
            }
        }

    }
}
