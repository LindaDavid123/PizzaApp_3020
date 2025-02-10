package com.example.pizzaapp_3020

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

class HomeActivity : AppCompatActivity() {
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTrx = fragmentManager.beginTransaction()
        fragmentTrx.replace(R.id.fragmentContainerView, fragment)
        fragmentTrx.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val txtAccount:TextView = findViewById(R.id.txtMenuAccount)
        val txtMenu:TextView = findViewById(R.id.txtMenuAccount)
        val txtTransaction:TextView = findViewById(R.id.txtMenuShopping)
        val txtReport:TextView = findViewById(R.id.txtMenuReport)
        val fragmentContainer:FragmentContainerView = findViewById(R.id.fragmentContainerView)

        txtAccount.setOnClickListener {
            replaceFragment(AccountFragment())
        }

        txtMenu.setOnClickListener {
            replaceFragment(MenuFragment())
        }

        txtTransaction.setOnClickListener {
            replaceFragment(TransactionFragment())
        }

        txtReport.setOnClickListener {
            replaceFragment(ReportFragment())
        }

    }
}