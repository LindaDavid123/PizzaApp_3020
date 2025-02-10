package com.example.pizzaapp_3020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.example.pizzaapp_3020.client.RetrofitClient
import com.example.pizzaapp_3020.response.account.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    companion object {
        var name = "Linda David"
        var email = "lindadavid@students.amikom.ac.id"
        var password = "Linda123"
        var level = "Owner"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txtUsername:EditText = findViewById(R.id.editTextText)
        val txtPassword:EditText = findViewById(R.id.editTextText2)
        val btnLogin:Button = findViewById(R.id.button2)
        btnLogin.setOnClickListener {
            var user = txtUsername.text.toString().trim()
            var password = txtPassword.text.toString().trim()

            if (user.isEmpty()){
                txtUsername.error = "Email required"
                txtUsername.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()){
                txtPassword.error = "Password required"
                txtPassword.requestFocus()
                return@setOnClickListener
            }

            RetrofitClient.instance.postLogin(user, password).enqueue(
                object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        val account = response.body()
                        if (account?.success == true){
                            Toast.makeText(this@LoginActivity, account?.message.toString(), Toast.LENGTH_SHORT).show()
                            val intentLogin = Intent(this@LoginActivity, AccountActivity::class.java)
                            startActivity(intentLogin)
                        } else {
                            Toast.makeText(this@LoginActivity, account?.message.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show()
                    }
                }
            )
        }
    }
}