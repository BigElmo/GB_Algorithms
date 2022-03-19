package com.bigelmo.algorithms.lesson4.deque;

public class LinkedDeque<E> implements Deque<E>{
    private final DequeLinkedList<E> data;

    public LinkedDeque() {
        this.data = new DequeLinkedListImpl<>();
    }

    @Override
    public boolean insert(E value) {
        insertLeft(value);
        return true;
    }

    @Override
    public E remove() {
        return removeRight();
    }

    @Override
    public E peekFront() {
        return data.getFirst();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        data.display();
    }

    @Override
    public String toString() {
        return "LinkedDeque{" + "data=" + data + '}';
    }

    @Override
    public boolean insertLeft(E value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertRight(E value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public E removeLeft() {
        return data.removeFirst();
    }

    @Override
    public E removeRight() {
        return data.removeLast();
    }
}
