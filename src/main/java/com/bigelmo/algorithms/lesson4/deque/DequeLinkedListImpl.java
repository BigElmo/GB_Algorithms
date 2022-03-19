package com.bigelmo.algorithms.lesson4.deque;

import java.util.Iterator;

public class DequeLinkedListImpl<E> implements DequeLinkedList<E> {

    protected int size;
    protected Node<E> first;
    protected Node<E> last;

    public DequeLinkedListImpl() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void insertFirst(E value) {
        if (isEmpty()) {
            first = new Node<>(value, null, null);
            last = first;
        } else {
            Node<E> currentFirst = first;
            first = new Node<>(value, currentFirst, null);
            currentFirst.prev = first;
        }
        size++;
    }

    @Override
    public void insertLast(E value) {
        if (isEmpty()) {
            insertFirst(value);
        } else {
            Node<E> currentLast = last;
            last = new Node<>(value, null, currentLast);
            currentLast.next = last;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        if (first == last) {
            Node<E> removed = first;
            first = null;
            last = null;
            size--;
            return removed.item;
        }
        Node<E> removed = first;
        first = first.next;
        first.prev = null;
        removed.next = null;
        size--;

        return removed.item;
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (first == last) {
            return removeFirst();
        }
        Node<E> removed = last;
        last = last.prev;
        last.next = null;
        removed.prev = null;
        size--;

        return removed.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }

        if (current == last) {
            removeLast();
            return true;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;

        size--;

        return true;
    }

    @Override
    public boolean contains(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while (current != null) {
            sb.append(current.item);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        return sb.append("]").toString();
    }

    @Override
    public E getFirst() {
        return first.item;
    }

    @Override
    public E getLast() {
        return last.item;
    }
}
