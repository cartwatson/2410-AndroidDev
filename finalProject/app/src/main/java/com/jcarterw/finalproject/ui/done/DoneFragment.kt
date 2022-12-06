package com.jcarterw.finalproject.ui.done

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcarterw.finalproject.ui.Ticket
import com.jcarterw.finalproject.databinding.FragmentDoneBinding


class DoneFragment : Fragment() {
    private var _binding: FragmentDoneBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentDoneBinding.inflate(inflater, container, false)

        val view: View = inflater.inflate(com.jcarterw.finalproject.R.layout.fragment_done, container, false)
        val rvDone = view.findViewById<View>(com.jcarterw.finalproject.R.id.rvDone) as RecyclerView
        val doneList = ArrayList<Ticket>()
        // add ticket if it has to do status
        for (ticket in Ticket.getTickets()) {
            if (ticket.status == "DONE") {
                doneList.add(ticket)
            }
        }
        rvDone.setHasFixedSize(false)
        rvDone.layoutManager = LinearLayoutManager(view.context)
        rvDone.adapter = DoneAdapter(doneList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}