package com.showtime.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.showtime.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var botaoCadastrar: Button? = null
    var botaoLogar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        message.text = "SE FODEU"

        botaoCadastrar = findViewById(R.id.btn_cadastrar_init) //referência do botão
        botaoLogar = findViewById(R.id.btn_login_init) //referência do botão


        botaoCadastrar?.setOnClickListener {
            var clickintent = Intent(this@MainActivity, UserCreateActivity::class.java)
            startActivity(clickintent)
        }

        botaoLogar?.setOnClickListener {
            var clicklog = Intent(this@MainActivity, UserLoginActivity::class.java)
            startActivity(clicklog)
        }

    }
}
