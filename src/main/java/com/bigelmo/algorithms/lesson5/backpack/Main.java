package com.bigelmo.algorithms.lesson5.backpack;

import java.util.ArrayList;

public class Main {
    // 1. Написать программу по возведению числа в степень с помощью рекурсии.
    // Задача в юнит-тесте.

    // 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
    public static void main(String[] args) {
        Backpack backpack = new Backpack(40);
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("item-1", 10, 150));
        items.add(new Item("item-2", 11, 250));
        items.add(new Item("item-3", 7, 100));
        items.add(new Item("item-4", 16, 10));
        items.add(new Item("item-5", 11, 170));
        items.add(new Item("item-6", 1, 30));
        items.add(new Item("item-7", 13, 190));
        items.add(new Item("item-8", 25, 390));

        backpack.select(items);
        backpack.showItems();
    }
}
