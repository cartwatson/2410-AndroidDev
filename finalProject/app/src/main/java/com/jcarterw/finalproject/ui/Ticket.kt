package com.jcarterw.finalproject.ui

class Ticket(val title: String, val desc: String, val status: String) {
    companion object {
        // TODO: modify this list when user creates ticket
        // TODO: get rid of initialization
        fun getTickets() : ArrayList<Ticket> {
            val tickets = ArrayList<Ticket>()
            // Hard code faculty list
            tickets.add(Ticket("Implement on device saving", "Save tickets to device", "TODO"))
            tickets.add(Ticket("Create ticket class","Create ticket class to be used throughout program", "IN PROGRESS"))
            tickets.add(Ticket("Create XML for statuses", "Create the a pretty layout for the various statuses", "TODO"))
            tickets.add(Ticket("Create Launch icon", "Create and implement custom launch icon", "TODO"))
            tickets.add(Ticket("Init proj/gradle", "Create project and gradle, confirm working", "DONE"))
            tickets.add(Ticket("Add way for user to create tickets", "add functionality", "TODO"))
            tickets.add(Ticket("Ticket 1", "lorem ipsum", "TODO"))
            tickets.add(Ticket("Ticket 2", "lorem ipsum", "IN PROGRESS"))
            tickets.add(Ticket("Ticket 3", "lorem ipsum", "DONE"))
            tickets.add(Ticket("Ticket 4", "lorem ipsum", "TODO"))
            tickets.add(Ticket("Ticket 5", "lorem ipsum", "IN PROGRESS"))
            tickets.add(Ticket("Ticket 6", "lorem ipsum", "DONE"))
            return tickets
        }
    }
}