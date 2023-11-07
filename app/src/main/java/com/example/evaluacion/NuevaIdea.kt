

package com.example.evaluacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class NuevaIdea : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_idea)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val editTextNombreIdea = findViewById<TextInputEditText>(R.id.editTextNombreIdea)
        val editTextDescripcionIdea = findViewById<TextInputEditText>(R.id.editTextDescripcionIdea)

        btnSave.setOnClickListener {
            val ideaTitle = editTextNombreIdea.text.toString().trim()
            val ideaDescription = editTextDescripcionIdea.text.toString().trim()

            if(ideaTitle.isNotEmpty() && ideaDescription.isNotEmpty()) {
                val intent = Intent(this, ViewIdeasActivity::class.java).apply {
                    putExtra("IDEA_TITLE", ideaTitle)
                    putExtra("IDEA_DESCRIPTION", ideaDescription)
                }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Por favor, ingrese título y descripción", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            // Crear un nuevo intent para MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Iniciar MainActivity
            startActivity(intent)
            finish()
        }
    }
}

