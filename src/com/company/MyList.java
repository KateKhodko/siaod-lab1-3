package com.company;

import com.sun.source.tree.NewArrayTree;

public class MyList {
    private final Node header = new Node();
    private Node current = header;

    private int size = 0;

    public void add(Person item) {
        /*
        Node node = new Node(item, null);
        if (header.next != null) {
            Node last = entry(size-1);
            last.next = node;
        } else {
            header.next = node;
        }
        size++;
         */
        current.next = new Node(item, null);
        current = current.next;
        size++;
    }

    public void remove(int index) {
        Node node = entry(index);
        if
        (node.next != null) {
            node.element = node.next.element;
            node.next = node.next.next;
        } else {
            node.element  = null;
            node.next = null;
        }
        size--;
    }

    public void set(int index, Person person) {
        Node node = entry(index);
        node.element = person;
    }

    public Person get(int i) {
        return entry(i).element;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private Node entry(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node node = header;

        for (int i = 0; i <= index; i++) {
            node = node.next;
        }
        return node;
    }

    private static class Node {
        Person element;
        Node next;

        Node() {
        }

        Node(Person element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

}
