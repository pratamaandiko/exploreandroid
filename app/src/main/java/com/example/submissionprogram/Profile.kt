package com.example.submissionprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.title = "Profil"
        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        val fotodiri: ImageView = findViewById(R.id.fotodiri)
        fotodiri.setImageResource(R.drawable.aku)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}