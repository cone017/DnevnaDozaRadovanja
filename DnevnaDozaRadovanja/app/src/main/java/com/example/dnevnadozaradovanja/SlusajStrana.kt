package com.example.dnevnadozaradovanja

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SlusajStrana() : AppCompatActivity() {

    public lateinit var mediaPlayer1: MediaPlayer
    public lateinit var mediaPlayer2: MediaPlayer
    public lateinit var mediaPlayer3: MediaPlayer
    public lateinit var mediaPlayer4: MediaPlayer
    public var image = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slusaj)

        mediaPlayer1 = MediaPlayer.create(this, R.raw.cuvanje_groba_copavog)
        mediaPlayer2 = MediaPlayer.create(this, R.raw.car_lazar)
        mediaPlayer3 = MediaPlayer.create(this, R.raw.pojavljivanje_grka)
        mediaPlayer4 = MediaPlayer.create(this, R.raw.jasnovac_lazne_informacije)

        findViewById<ImageButton>(R.id.buttonSong1).setOnClickListener {
            playSound(mediaPlayer1,findViewById<ImageButton>(R.id.buttonSong1) )
            changeImage(findViewById<ImageButton>(R.id.buttonSong1))
        }
        findViewById<ImageButton>(R.id.buttonSong2).setOnClickListener {
            playSound(mediaPlayer2, findViewById<ImageButton>(R.id.buttonSong2))
            changeImage(findViewById<ImageButton>(R.id.buttonSong2))
        }
        findViewById<ImageButton>(R.id.buttonSong3).setOnClickListener {
            playSound(mediaPlayer3, findViewById<ImageButton>(R.id.buttonSong3))
            changeImage(findViewById<ImageButton>(R.id.buttonSong3))
        }

        findViewById<ImageButton>(R.id.buttonSong4).setOnClickListener {
            playSound(mediaPlayer4, findViewById<ImageButton>(R.id.buttonSong4))
            changeImage(findViewById<ImageButton>(R.id.buttonSong4))
        }

        val drugaStrana = findViewById<FloatingActionButton>(R.id.fab)
        drugaStrana.setOnClickListener{
            val Intent = Intent(this, DrugaStrana::class.java)
            startActivity(Intent)
        }
    }

    public fun playSound(mediaPlayer: MediaPlayer, button: ImageButton) {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            image = false
        }

        else {
            mediaPlayer.start()
            image = true
            mediaPlayer.setOnCompletionListener { changeImage(button) }
        }
    }

    public override fun onDestroy() {
        super.onDestroy()
        mediaPlayer1.release()
        mediaPlayer2.release()
    }

    public fun changeImage(button: ImageButton) {
        if (image)
            button.setImageResource(R.drawable.pause_button)
        else
            button.setImageResource(R.drawable.play_button)
    }
}