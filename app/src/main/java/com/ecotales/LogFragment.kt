package com.ecotales

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecotales.databinding.FragmentFirstBinding
import com.ecotales.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LogFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private lateinit var wetlandDao: WetlandDao
    private var wetLandList: LiveData<List<WetlandEntity>>? = null
    private lateinit var viewModel: LogViewmodel
    private lateinit var recyclerView: RecyclerView
    private lateinit var itemAdapter: LogAdapter
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        recyclerView = binding.recylerView


        itemAdapter = LogAdapter(emptyList()) { selectedItem ->

        }
        recyclerView.adapter = itemAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        return binding.root
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LogViewmodel::class.java)
        val appDataBase = AppDatabase.getInstance(requireContext())
        if (appDataBase != null) {
            //     wetLandList = appDataBase.wetlandDao.getWetland()
            println("appDataBase::::::::"+appDataBase)
            viewModel.allEntities.observe(viewLifecycleOwner, Observer { entities ->
                // Update UI based on the changes in the database
                // entities is the updated list of YourEntity objects
                println("entites:::::::"+entities)
                itemAdapter = LogAdapter(entities) { selectedItem ->
                    // Handle item click, e.g., open a new activity

                }

                recyclerView.adapter = itemAdapter
            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}