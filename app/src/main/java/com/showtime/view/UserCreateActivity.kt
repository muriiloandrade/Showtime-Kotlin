package com.showtime.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.showtime.R

class UserCreateActivity : AppCompatActivity() {

    var botaoVoltar: Button? = null;
    var botaoLogar: TextView? = null;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_create)

        botaoVoltar = findViewById(R.id.btn_voltar)
        botaoLogar = findViewById(R.id.textViewLogin)


        botaoVoltar?.setOnClickListener {
            var clickintent = Intent(this@UserCreateActivity, MainActivity::class.java)
            startActivity(clickintent)
        }

        botaoLogar?.setOnClickListener {
            var clickintent = Intent(this@UserCreateActivity, UserLoginActivity::class.java)
            startActivity(clickintent)
        }
    }
}
