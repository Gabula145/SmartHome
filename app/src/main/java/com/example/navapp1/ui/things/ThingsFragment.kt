package com.example.navapp1.ui.things

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.navapp1.databinding.FragmentThingsBinding

class ThingsFragment : Fragment() {

    private var _binding: FragmentThingsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val thingsViewModel =
            ViewModelProvider(this).get(ThingsViewModel::class.java)

        _binding = FragmentThingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textThings
        thingsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}