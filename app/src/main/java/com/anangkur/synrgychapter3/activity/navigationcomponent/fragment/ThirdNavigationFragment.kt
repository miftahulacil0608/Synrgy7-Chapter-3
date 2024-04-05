package com.anangkur.synrgychapter3.activity.navigationcomponent.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anangkur.synrgychapter3.databinding.FragmentThirdNavigationBinding

class ThirdNavigationFragment : Fragment() {

    private lateinit var binding: FragmentThirdNavigationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentThirdNavigationBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvName.text = "Namanya: ${getName()}"
    }

    /**
     * Retrieves the name argument passed to the third fragment.
     *
     * This function extracts and returns the name argument passed to the third fragment.
     * It retrieves the argument using the generated NavArgs class (ThirdNavigationFragmentArgs)
     * and the fromBundle method from the fragment's arguments Bundle.
     *
     * @return The name argument passed to the third fragment.
     */
    private fun getName(): String {
        return ThirdNavigationFragmentArgs.fromBundle(arguments as Bundle).name
    }
}