package com.example.submissionprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class DetailFakultasActivity : AppCompatActivity() {

    companion object {
        const val FAKULTAS = "FAKULTAS"
    }
    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_fakultas)
        var actionBar = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }
        val ivphoto: ImageView = findViewById(R.id.ivphoto)
        val tvFakultas: TextView = findViewById(R.id.tvFakultas)
        val tvphone: TextView = findViewById(R.id.tvphone)
        val alamat: TextView = findViewById(R.id.alamat)
        val tvwebsite: TextView = findViewById(R.id.tvwebsite)
        val tvdetail: TextView = findViewById(R.id.tvdetail)

        val fakultas = intent.getSerializableExtra(FAKULTAS) as Fakultas

        ivphoto.setImageResource(fakultas.photo)
        tvFakultas.text = fakultas.name
        tvphone.text = fakultas.phone
        alamat.text = fakultas.alamat
        tvwebsite.text = fakultas.website
        tvdetail.text = fakultas.detail
        setActionBarTitle(fakultas.name)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}