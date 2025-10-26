package org.example.util;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<Item> implements Iterable<Item> {
    private LinkedList<Item> list = new LinkedList<>();

    public void enqueue(Item item) {
        list.addLast(item);
    }

    public Item dequeue() {
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    @Override
    public Iterator<Item> iterator() {
        return list.iterator();
    }
}
