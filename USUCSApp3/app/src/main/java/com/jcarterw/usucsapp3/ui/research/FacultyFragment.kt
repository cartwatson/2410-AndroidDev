package com.jcarterw.usucsapp3.ui.research

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcarterw.usucsapp3.databinding.FragmentFacultyBinding


class FacultyFragment : Fragment() {
    private var _binding: FragmentFacultyBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view: View = inflater.inflate(com.jcarterw.usucsapp3.R.layout.fragment_faculty, container, false)
        val rvFaculty = view.findViewById<View>(com.jcarterw.usucsapp3.R.id.rvFaculty) as RecyclerView
        val facultyList = FacultyMember.createFacultyList()
        rvFaculty.setHasFixedSize(true)
        rvFaculty.layoutManager = LinearLayoutManager(view.context)
        rvFaculty.adapter = FacultyAdapter(facultyList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}