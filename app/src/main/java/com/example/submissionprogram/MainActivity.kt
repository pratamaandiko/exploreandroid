package com.example.submissionprogram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFakultas: RecyclerView
    private var list: ArrayList<Fakultas> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFakultas = findViewById(R.id.rv_fakultas)
        rvFakultas.setHasFixedSize(true)
        list.addAll(DataFakultas.listData)
        showRecyclerList()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private fun showRecyclerList() {
        rvFakultas.layoutManager = LinearLayoutManager(this)
        val listFakultasAdapter = ListFakultasAdapter(list)
        rvFakultas.adapter = listFakultasAdapter

        listFakultasAdapter.setOnItemClickCallback(object : ListFakultasAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Fakultas) {
                selectedFakultas(data)
            }
        })
    }
    private fun selectedFakultas(fakultas: Fakultas) {
            val moveWithDataIntent = Intent(this@MainActivity, DetailFakultasActivity::class.java)
            moveWithDataIntent.putExtra(DetailFakultasActivity.FAKULTAS,fakultas)
            startActivity(moveWithDataIntent)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val moveIntent = Intent(this@MainActivity, Profile::class.java)
        startActivity(moveIntent)
        return super.onOptionsItemSelected(item)
    }
}