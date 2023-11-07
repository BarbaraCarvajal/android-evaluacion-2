package com.example.evaluacion

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class ViewIdeasActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var btnBack: Button
    private lateinit var adapter: ArrayAdapter<String>

    // Lista de ideas mutable
    private val ideasList = ArrayList<Idea>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_ideas)

        listView = findViewById(R.id.lvIdeas)
        btnBack = findViewById(R.id.btnBack)

        // Añadir las ideas de ejemplo a la lista mutable
        ideasList.add(Idea("Crear sitio web para pyme venta de sushi","tomar requerimientos al cliente"))
        ideasList.add(Idea("Diseñar ux/ui", "Diseñar en Figma el diseño del sitio web"))

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_2,
            android.R.id.text1,
            ideasList.map { "${it.title}\n${it.description}" }
        )

        listView.adapter = adapter

        btnBack.setOnClickListener {
            // Crear un nuevo intent para MainActivity
            val intent = Intent(this, MainActivity::class.java)
            // Iniciar MainActivity
            startActivity(intent)
            finish()
        }

        // Verificar si hay datos nuevos para añadir a la lista
        intent?.extras?.let {
            val ideaTitle = it.getString("IDEA_TITLE", "")
            val ideaDescription = it.getString("IDEA_DESCRIPTION", "")

            if (ideaTitle.isNotEmpty() && ideaDescription.isNotEmpty()) {
                val newIdea = Idea(ideaTitle, ideaDescription)
                ideasList.add(newIdea)
                adapter.notifyDataSetChanged() // Notificar al adaptador que hay un nuevo elemento
            }
        }
    }

    data class Idea(val title: String, val description: String)
}
