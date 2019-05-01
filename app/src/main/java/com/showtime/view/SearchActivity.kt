package com.showtime.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatImageButton
import com.showtime.R
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    var botaoSearch: AppCompatImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)



        botaoSearch = findViewById(R.id.btn_search)

        botaoSearch?.setOnClickListener {
            val clicksearch = Intent(this@SearchActivity, SearchSeriesActivity::class.java)

            var nomeSerie = editTextSerie.text.toString().trim()

            if (nomeSerie.isEmpty()) {
                editTextSerie.error = "Nome da série obrigatório"
                editTextSerie.requestFocus()
                return@setOnClickListener
            }

            startActivity(clicksearch)
        }
    }
}