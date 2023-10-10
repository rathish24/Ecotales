package com.ecotales

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ecotales.databinding.ActivityAddwetlogBinding

class AddWetLog:AppCompatActivity() {
    private lateinit var binding: ActivityAddwetlogBinding
    private lateinit var viewModel: LogViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogViewmodel::class.java)
        binding = ActivityAddwetlogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        binding.toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }


        binding.btnSubmit.setOnClickListener(View.OnClickListener {

            var observations  = binding.etRegion.text.toString()
            var district = binding.etRegion.text.toString()
            var placeVisisted = binding.etRegion.text.toString()

            println("observations:::: "+observations)
            println("district:::: "+district)
            println("placeVisisted:::: "+placeVisisted)
            var logEntity = LogEntity(0,placeVisisted,district,observations)
            viewModel.insert(logEntity)
            Toast.makeText(
                applicationContext,
                "Submitted succesfully",
                Toast.LENGTH_SHORT
            ).show()
            finish()

        })

    }

}