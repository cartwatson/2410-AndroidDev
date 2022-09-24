package com.jcarterw.a2_webbrowser;

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

    }

    node head;
    node curr;
    node tail;

    History() {
        node home = new node("", null, null);
        head = home;
        tail = home;
        curr = home;
    }

    public void appendNode (String d) {
        if (curr.next != null) {
            // other nodes in list TODO: delete those stupid bitch ass nodes
            
        }
        node temp = new node(d);
        tail.next = temp;
        temp.prev = tail;
        temp.next = null;
        tail = temp;
        curr = tail;
    }

    public void prevCurr () { if (curr.prev != null) { curr = curr.prev; } }
    public void nextCurr () { if (curr.next != null) { curr = curr.next; } }

    public String getData () { return curr.data; }
}
