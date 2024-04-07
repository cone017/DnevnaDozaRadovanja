package com.example.dnevnadozaradovanja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pocetna)

        val drugaStrana = findViewById<Button>(R.id.btn_zov)
        drugaStrana.setOnClickListener{
            val Intent = Intent(this, DrugaStrana::class.java)
            startActivity(Intent)
        }
    }
}