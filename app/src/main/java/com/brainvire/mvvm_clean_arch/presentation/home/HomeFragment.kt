package com.brainvire.mvvm_clean_arch.presentation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.brainvire.learning.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var TAG = "HomeFragment"

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]


        collectCategoryData()

        return binding.root
    }

    private fun collectCategoryData() {
        lifecycleScope.launch {
            viewModel.categoryState.collect {
                if (it.isLoading) {
                    Log.d(TAG, "collectCategoryData: isLoading")
                } else if (it.error.isNotEmpty()) {
                    Log.e(TAG, "collectCategoryData Error: ${it.error}")
                    Toast.makeText(activity, it.error, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Log.d(TAG, "collectCategoryData success:${it.data}")
                }
            }
        }
    }

}