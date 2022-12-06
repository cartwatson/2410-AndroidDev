package com.jcarterw.finalproject.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jcarterw.finalproject.ui.Ticket
import com.jcarterw.finalproject.databinding.FragmentTodoBinding


class TodoFragment : Fragment() {
    private var _binding: FragmentTodoBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)

        val view: View = inflater.inflate(com.jcarterw.finalproject.R.layout.fragment_todo, container, false)
        val rvTodo = view.findViewById<View>(com.jcarterw.finalproject.R.id.rvTodo) as RecyclerView
        val todoList = ArrayList<Ticket>()
        // add ticket if it has to do status
        for (ticket in Ticket.getTickets()) {
            if (ticket.status == "TODO") {
                todoList.add(ticket)
            }
        }
        rvTodo.setHasFixedSize(false)
        rvTodo.layoutManager = LinearLayoutManager(view.context)
        rvTodo.adapter = TodoAdapter(todoList)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}