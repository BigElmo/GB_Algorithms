package com.bigelmo.algorithms.lesson2;

import com.bigelmo.algorithms.lesson2.comparators.MakerComparator;
import com.bigelmo.algorithms.lesson2.comparators.PriceComparator;
import com.bigelmo.algorithms.lesson2.comparators.RamComparator;

import java.util.ArrayList;
import java.util.Comparator;

public class Lesson2Main {

    private static ArrayList<String> makers;
    private static ArrayList<Notebook> notebooks;

    public static void main(String[] args) {
        Comparator<Notebook> comparator = new PriceComparator()
                .thenComparing(new RamComparator())
                .thenComparing(new MakerComparator());

        generateMakers();
        generateNotebooks();
//        System.out.println(notebooks);
        long startTime = System.currentTimeMillis();
        notebooks.sort(comparator);
        long endTime = System.currentTimeMillis();
//        System.out.println(notebooks);
        System.out.println("Отсортировано за: " + (endTime - startTime) + "мс");
    }

    private static void generateNotebooks() {
        notebooks = new ArrayList<>(10000);
        for (int i = 0; i < 10000; i++) {
            int price = ((int) (Math.random() * 31) + 10) * 50;
            int ram = ((int) (Math.random() * 6) + 1) * 4;
            String maker = makers.get((int) (Math.random() * makers.size()));
            notebooks.add(new Notebook(price, ram, maker));
        }
    }

    private static void generateMakers() {
        makers = new ArrayList<>();
        makers.add("Lenuvo");
        makers.add("Asos");
        makers.add("MacNote");
        makers.add("Eser");
        makers.add("Xamiou");
    }

    public static ArrayList<String> getMakers() {
        return makers;
    }
}
