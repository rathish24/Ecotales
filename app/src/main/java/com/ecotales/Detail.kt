package com.ecotales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ecotales.databinding.ActivityMainBinding
import com.ecotales.databinding.DetailActivityBinding


class Detail : AppCompatActivity() {
    private lateinit var binding: DetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }

        // Retrieve the selected item ID from the intent
        val title = intent.getStringExtra("title")
        println("title:::::"+title)

        // TODO: Use the item ID as needed
    }
}