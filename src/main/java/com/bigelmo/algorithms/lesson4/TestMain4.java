package com.bigelmo.algorithms.lesson4;

import com.bigelmo.algorithms.lesson4.deque.Deque;
import com.bigelmo.algorithms.lesson4.deque.LinkedDeque;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class TestMain4 {

    public static void main(String[] args) {
//        testLinkedList();
//        testHomeWork();
//        testIterator();
//        testInsertAt();
        testLinkedDeque();
    }

    // Задание 1. реализация Deque
    private static void testLinkedDeque() {
        Deque<Integer> myDeque = new LinkedDeque<>();

        myDeque.insert(1);
        myDeque.insert(2);
        myDeque.insert(3);
        myDeque.insert(4);
        myDeque.insert(5);
        myDeque.display();
        myDeque.remove();
        myDeque.remove();
        myDeque.remove();
        myDeque.display();
        myDeque.insertRight(6);
        myDeque.insertLeft(7);
        myDeque.display();
    }

    private static void testInsertAt() {

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);

        linkedList.display();

        linkedList.insertAfter(3, 44);

        linkedList.display();
    }

    private static void testLinkedList() {

        TwoSideLinkedList<Integer> linkedList = new TwoSideLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);
        linkedList.insertLast(9);
        linkedList.insertLast(10);
        linkedList.insertLast(11);

        linkedList.display();

        System.out.println("Find 2: " + linkedList.contains(2));
        System.out.println("Find 1: " + linkedList.contains(1));
        System.out.println("Find 4: " + linkedList.contains(4));
        System.out.println("Find 4444: " + linkedList.contains(4444));

        System.out.println("remove first: " + linkedList.removeFirst());
        linkedList.remove(4);
        linkedList.remove(11);
//
        linkedList.display();

    }

    // 2. Реализовать итератор
    private static void testHomeWork() {
        //ДОЛЖНО РАБОТАТЬ!

        SimpleLinkedListImpl<Integer> linkedList = new SimpleLinkedListImpl<>();

        linkedList.insertFirst(1);
        linkedList.insertFirst(2);
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(5);
        linkedList.insertFirst(6);
        linkedList.insertFirst(7);
        linkedList.insertFirst(8);

        for (Integer value : linkedList) {
            System.out.println("value: " + value);
        }
    }


    private static void testIterator() {
        List<Integer> linkedList = new java.util.LinkedList<>();
        Collections.addAll(linkedList, 1, 2, 3, 4, 5, 6, 7, 8, 9);

/*        for (Integer integer : linkedList) {
            System.out.println(integer);
        }*/
        ListIterator<Integer> iterator = linkedList.listIterator();
        //first:reset
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            System.out.println(integer + " до него: " + iterator.previousIndex());
        }

    }
}
