package com.example.wisefleet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReportesUsoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ReportesUsoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_reportesuso, container, false)

        val fab: FloatingActionButton? = view?.findViewById(R.id.btnAddReporte)
        fab?.setOnClickListener {
            IniciarActivity(NuevoEditarReporteUsoActivity())
        }
        return view
    }

    fun IniciarActivity(activity: Activity) {
        val intent = Intent(this.activity, activity::class.java)
        startActivity(intent)
    }
}