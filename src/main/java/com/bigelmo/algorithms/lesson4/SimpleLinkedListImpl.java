package com.bigelmo.algorithms.lesson4;

import java.util.Iterator;

public class SimpleLinkedListImpl<E> implements LinkedList<E>, Iterable<E> {
    protected int size;
    protected Node<E> first;


    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
/*        Node<E> actualFirst = first;
        Node<E> newFirst = new Node<>(value, actualFirst);
        this.first = newFirst;*/
        size++;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {

        Node<E> prev = null;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == first) {
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }
    // 3. Реализовать метод insert.
    // Не совсем понял задачу, поэтому сделал метод, вставляющий элемент следом за указанным
    public boolean insertAfter(E target, E value) {
        Node<E> prev;
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(target)) {
                prev = current;
                prev.next = new Node<>(value, current.next);
                return true;
            }
            current = current.next;
        }
        return false;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while (current != null) {
            if (current.item.equals(value)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
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
    public Iterator<E> iterator() {
        return new ListIterator();
    }
    // 2. Реализовать итератор
    private class ListIterator implements Iterator<E> {

        private Node<E> current;

        private ListIterator() {
            this.reset();
        }

        private void reset() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E item = current.item;
            current = current.next;
            return item;
        }
    }
}
