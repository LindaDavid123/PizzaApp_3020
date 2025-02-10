package com.example.pizzaapp_3020

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class AccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account)


        val txtNama: EditText = findViewById(R.id.editTextText3)
        val txtEmail:EditText = findViewById(R.id.editTextText4)
        val txtPassword:EditText = findViewById(R.id.editTextText5)
        val txtLevel:EditText = findViewById(R.id.editTextText6)

        txtNama.setText(LoginActivity.name)
        txtEmail.setText(LoginActivity.email)
        txtPassword.setText(LoginActivity.password)
        txtLevel.setText(LoginActivity.level)

        val dial:ImageButton = findViewById(R.id.callButton)
        dial.setOnClickListener {
            val dialIntent: Intent = Uri.parse("tel:081314640046").let{
                    number->Intent(Intent.ACTION_DIAL,number)
            }
            startActivity(dialIntent)
        }

        val website:ImageButton = findViewById(R.id.websiteButton)
        website.setOnClickListener {
            val webIntent:Intent =Uri.parse("https://home.amikom.ac.id/").let{
                    webpage->Intent(Intent.ACTION_VIEW,webpage)
            }
            startActivity(webIntent)
        }

        val maps:ImageButton = findViewById(R.id.locationButton)
        maps.setOnClickListener {
            val mapIntent:Intent = Uri.parse("geo:47.6,-122,3?z=11").let{
                    gmaps->Intent(Intent.ACTION_VIEW,gmaps)
            }
            mapIntent.setPackage("com.google.android.app.maps")
            startActivity(mapIntent)
        }

    }
}