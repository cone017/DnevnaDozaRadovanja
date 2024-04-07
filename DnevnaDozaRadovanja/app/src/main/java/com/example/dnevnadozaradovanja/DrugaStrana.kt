package com.example.dnevnadozaradovanja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button;

class DrugaStrana : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.druga)

        val drugaStrana = findViewById<Button>(R.id.btn_kupi)
        val slusajStrana = findViewById<Button>(R.id.btn_audio)

        drugaStrana.setOnClickListener{
            val Intent = Intent(this, KnjigeStrana::class.java)
            startActivity(Intent)
        }

        slusajStrana.setOnClickListener{
            val Intent = Intent(this, SlusajStrana::class.java)
            startActivity(Intent)
        }
    }
}