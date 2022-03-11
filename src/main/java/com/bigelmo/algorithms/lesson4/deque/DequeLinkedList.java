package com.bigelmo.algorithms.lesson4.deque;

public interface DequeLinkedList<E> {
    void insertFirst(E value);

    void insertLast(E value);

    E removeFirst();

    E removeLast();

    boolean remove(E value);

    boolean contains(E value);

    int size();

    boolean isEmpty();

    void display();

    E getFirst();

    E getLast();

    class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }
}
