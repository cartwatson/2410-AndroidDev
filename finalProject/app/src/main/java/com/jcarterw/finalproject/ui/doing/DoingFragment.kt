package com.jcarterw.finalproject.ui.doing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcarterw.finalproject.ui.Ticket
import com.jcarterw.finalproject.databinding.FragmentDoingBinding


class DoingFragment : Fragment() {
    private var _binding: FragmentDoingBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDoingBinding.inflate(inflater, container, false)

        val view: View = inflater.inflate(com.jcarterw.finalproject.R.layout.fragment_doing, container, false)
        val rvDoing = view.findViewById<View>(com.jcarterw.finalproject.R.id.rvDoing) as RecyclerView
        val progressList = ArrayList<Ticket>()
        // add ticket if it has to do status
        for (ticket in Ticket.getTickets()) {
            if (ticket.status == "IN PROGRESS") {
                progressList.add(ticket)
            }
        }
        rvDoing.setHasFixedSize(false)
        rvDoing.layoutManager = LinearLayoutManager(view.context)
        rvDoing.adapter = DoingAdapter(progressList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}