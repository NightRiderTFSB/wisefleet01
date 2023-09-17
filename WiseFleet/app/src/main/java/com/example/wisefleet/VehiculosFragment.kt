package com.example.wisefleet

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.wisefleet.databinding.FragmentConfiguracionBinding

/**
 * A simple [Fragment] subclass.
 * Use the [VehiculosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class VehiculosFragment : Fragment() {

    private var _binding: FragmentConfiguracionBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_vehiculos, container, false)
    }

}