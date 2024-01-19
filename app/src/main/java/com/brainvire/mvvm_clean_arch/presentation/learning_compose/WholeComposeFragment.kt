package com.brainvire.mvvm_clean_arch.presentation.learning_compose

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Text
import androidx.compose.ui.platform.ComposeView
import com.brainvire.learning.R
import com.brainvire.mvvm_clean_arch.presentation.learning_compose.component.WholeComposeScreen

class WholeComposeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_whole_compose, container, false)
        return ComposeView(requireContext()).apply {
            setContent { 
                WholeComposeScreen()
            }
        }
    }
}