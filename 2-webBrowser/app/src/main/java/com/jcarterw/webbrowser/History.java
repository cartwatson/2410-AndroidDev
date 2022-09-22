package com.jcarterw.webbrowser;

public class History {
    // node class for doubly linked list
    private class node {
        String data;
        node prev;
        node next;

        node(String data) { this.data = data; }
        node(String data, node prev, node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public void setNext(node next) { this.next = next; }
        public void setPrev(node prev) { this.prev = prev; }
    }

    node head;
    node tail;

    History() {
        node home = new node("home", null, null);
        head = home;
        tail = home;
    }

    public void addNode (String d) {
        node temp = new node(d);


    }
}
