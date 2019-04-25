package com.showtime.view

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.showtime.R
import com.showtime.model.ShowtimeApiInterface
import com.showtime.model.UserLogin
import kotlinx.android.synthetic.main.activity_user_login.editTextSenha
import kotlinx.android.synthetic.main.activity_user_login.editTextEmail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserLoginActivity : AppCompatActivity() {

    var botaoLogin: Button? = null;
    var botaoCadastrar: Button? = null;
    val context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_login)

        botaoLogin = findViewById(R.id.btn_login)
        botaoCadastrar = findViewById(R.id.btn_cadastro)


        botaoCadastrar?.setOnClickListener {
            var clickintent = Intent(this@UserLoginActivity, UserCreateActivity::class.java)
            startActivity(clickintent)
        }

        botaoLogin?.setOnClickListener {
            var email = editTextEmail.text.toString().trim()
            var senha = editTextSenha.text.toString().trim()

            if (email.isEmpty()) {
                editTextEmail.error = "Email é obrigatório"
                editTextEmail.requestFocus()
                return@setOnClickListener
            }

            if (senha.isEmpty()) {
                editTextSenha.error = "A senha deve conter ao menos 8 dígitos"
                editTextSenha.requestFocus()
                return@setOnClickListener
            }

            val userToLogin = UserLogin(email, senha)

            val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://10.0.2.2:5000/api/v1/users/")
                .build()

            val client = retrofit.create(ShowtimeApiInterface::class.java)
            val responseCall = client.login(userToLogin)

            responseCall.enqueue(object : Callback<UserLogin> {
                override fun onResponse(call: Call<UserLogin>?, response: Response<UserLogin>?) {
                    if (response!!.code() == 200) {
                        Toast.makeText(context, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                        var clickintent = Intent(this@UserLoginActivity, GetAllSeriesActivity::class.java)
                        startActivity(clickintent)
                    } else {
                        Toast.makeText(context, "Email e/ou senha incorretos", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserLogin>?, t: Throwable?) {
                    Toast.makeText(context, "Falha ao logar, tente novamente mais tarde!", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }
    }
}
