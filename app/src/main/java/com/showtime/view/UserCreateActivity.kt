package com.showtime.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.showtime.R
import com.showtime.model.ShowtimeApiInterface
import com.showtime.model.User
import kotlinx.android.synthetic.main.activity_user_create.*
import kotlinx.android.synthetic.main.activity_user_create.editTextEmail
import kotlinx.android.synthetic.main.activity_user_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserCreateActivity : AppCompatActivity() {
    var botaoVoltar: Button? = null
    var botaoLogar: TextView? = null
    var botaoCadastrar: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_create)

        val context = this
        botaoVoltar = findViewById(R.id.btn_voltar)
        botaoLogar = findViewById(R.id.textViewLogin)
        botaoCadastrar = findViewById(R.id.btn_cadastrar)

        botaoVoltar?.setOnClickListener {
            var clickintent = Intent(this@UserCreateActivity, MainActivity::class.java)
            startActivity(clickintent)
        }

        botaoLogar?.setOnClickListener {
            var clickget = Intent(this@UserCreateActivity, UserLoginActivity::class.java)
            startActivity(clickget)
        }

        botaoCadastrar?.setOnClickListener {

            var nome = editTextNome.text.toString().trim()
            var email = editTextEmail.text.toString().trim()
            var senha = editTextPassword.text.toString().trim()

            if (nome.isEmpty()) {
                editTextNome.error = "O nome deve conter no mínimo 3 caracteres"
                editTextNome.requestFocus()
                return@setOnClickListener
            }

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

            val newUser = User(nome, email, senha)

            val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.1.13:5000/api/v1/users/")
                .build()

            val client = retrofit.create(ShowtimeApiInterface::class.java)
            val responseCall = client.addUser(newUser)

            responseCall.enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>?, response: Response<User>?) {
                    if (response?.code() == 200) {
                        Toast.makeText(context, "Cadastro efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                        var clickintent = Intent(this@UserCreateActivity, UserLoginActivity::class.java)
                        startActivity(clickintent)
                    } else {
                        Toast.makeText(context, "Email já está cadastrado", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<User>?, t: Throwable?) {
                    Toast.makeText(context, "Falha ao cadastrar, tente novamente mais tarde!", Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }

    }
}
