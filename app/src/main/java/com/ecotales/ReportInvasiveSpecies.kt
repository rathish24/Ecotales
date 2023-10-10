package com.ecotales

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ecotales.databinding.ActivityReportBinding

class ReportInvasiveSpecies : AppCompatActivity()  {
    private lateinit var binding: ActivityReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityReportBinding.inflate(layoutInflater)
                setContentView(binding.root)

                setSupportActionBar(binding.toolbar)
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                binding.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
    }


}

