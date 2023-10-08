package com.ecotales

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ecotales.databinding.FragmentFirstBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var wetlandDao: WetlandDao
    private var wetLandList: LiveData<List<WetlandEntity>>? = null
    private lateinit var viewModel: WetlandViewmodel


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WetlandViewmodel::class.java)

        binding.buttonFirst.setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        val appDataBase = AppDatabase.getInstance(requireContext())
        if (appDataBase != null) {
       //     wetLandList = appDataBase.wetlandDao.getWetland()
            println("appDataBase::::::::"+appDataBase)
            viewModel.allEntities.observe(viewLifecycleOwner, Observer { entities ->
                // Update UI based on the changes in the database
                // entities is the updated list of YourEntity objects
                println("entites:::::::"+entities)
            })
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}