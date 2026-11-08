package com.freenet50gb.app

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(32, 48, 32, 32)
        }

        val title = TextView(this).apply {
            text = "NAV VPN"
            textSize = 30f
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "Choisissez un pays pour préparer votre connexion."
            textSize = 16f
            gravity = Gravity.CENTER
        }

        val countries = Spinner(this)
        val list = listOf("Cameroun", "Allemagne", "France", "États-Unis", "Autre pays")
        countries.adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            list
        )

        val connect = Button(this).apply {
            text = "Se connecter"
            setOnClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "Aucun serveur VPN n'est encore configuré.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        layout.addView(title)
        layout.addView(subtitle)
        layout.addView(countries)
        layout.addView(connect)

        setContentView(layout)
    }
}
