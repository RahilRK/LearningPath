package com.brainvire.mvvm_clean_arch.presentation.pagination

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaginationFragment : Fragment() {

    private lateinit var viewModel: PaginationViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_pagination, container, false)
        viewModel = ViewModelProvider(this)[PaginationViewModel::class.java]
        return ComposeView(requireContext()).apply {
            setContent {
                FoodListScreen(viewModel)
            }
        }
    }
}