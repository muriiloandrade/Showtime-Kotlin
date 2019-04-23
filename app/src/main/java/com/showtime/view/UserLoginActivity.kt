package com.showtime.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.showtime.R

class UserLoginActivity : AppCompatActivity() {

    var botaoLogin: Button? = null;
    var botaoCadastrar: Button? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        botaoLogin = findViewById(R.id.btn_login)
        botaoCadastrar = findViewById(R.id.btn_cadastro)


        botaoCadastrar?.setOnClickListener {
            var clickintent = Intent(this@UserLoginActivity, UserCreateActivity::class.java)
            startActivity(clickintent)
        }

    }
}
