package com.jcarterw.finalproject.ui.doing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jcarterw.finalproject.R
import com.jcarterw.finalproject.ui.Ticket

class DoingAdapter(private val mTicket: List<Ticket>) : RecyclerView.Adapter<DoingAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById<TextView>(R.id.ticket_title)
        val descTextView: TextView = itemView.findViewById<TextView>(R.id.ticket_desc)
        val statusTextView: TextView = itemView.findViewById<TextView>(R.id.ticket_status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val facultyView = inflater.inflate(R.layout.item_ticket, parent, false)
        return ViewHolder(facultyView)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val faculty: Ticket = mTicket[position]
        val titleTextView = viewHolder.titleTextView
        titleTextView.text = faculty.title
        val descTextView = viewHolder.descTextView
        descTextView.text = faculty.desc
        val statusTextView = viewHolder.statusTextView
        statusTextView.text = faculty.status
    }

    override fun getItemCount(): Int {
        return mTicket.size
    }
}