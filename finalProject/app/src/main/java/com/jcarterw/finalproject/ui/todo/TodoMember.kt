package com.jcarterw.usucsapp3.ui.faculty

class TodoMember(val name: String, val title: String, val office: String) {
    companion object {
        fun createFacultyList() : ArrayList<TodoMember> {
            val facultyMembers = ArrayList<TodoMember>()
            // Hard code faculty list
            facultyMembers.add(TodoMember("Mahdi Nasrullah Al-Ameen", "Assistant Professor", "Old Main 401F"))
            facultyMembers.add(TodoMember("Vicki Allan","Associate Professor", "Old Main 429"))
            facultyMembers.add(TodoMember("Soukaina Filali Boubrahimi", "Assistant Professor", "Old Main 401A"))
            facultyMembers.add(TodoMember("Heng-Da Cheng", "Professor", "Old Main 401B"))
            facultyMembers.add(TodoMember("Isaac Cho", "Assistant Professor", "Old Main 402G"))
            facultyMembers.add(TodoMember("Stephen Clyde", "Emeritus Associate Professor", "Old Main 418"))
            facultyMembers.add(TodoMember("Joseph Ditton", "Professional Practice Assistant Professor", "Old Main 420"))
            facultyMembers.add(TodoMember("Curtis Dyreson", "Professor", "Old Main 402A"))
            facultyMembers.add(TodoMember("John Edwards", "Assistant Professor", "Old Main 401D"))
            facultyMembers.add(TodoMember("Nicholas Flann", "Associate Professor", "Old Main 402C"))
            return facultyMembers
        }
    }
}