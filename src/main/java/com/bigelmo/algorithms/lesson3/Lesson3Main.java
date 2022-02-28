package com.bigelmo.algorithms.lesson3;

import java.util.ArrayList;

public class Lesson3Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = generateArrayList(1000000);
//        System.out.println(list);
        long start = System.currentTimeMillis();
        System.out.println(linearSearch(list));
        System.out.println(System.currentTimeMillis() - start + "ms");
        start = System.currentTimeMillis();
        System.out.println(sumSearch(list));
        System.out.println(System.currentTimeMillis() - start + "ms");
    }

    //O(n) Выигрывает у линейного только при size < 100000, нет лучшего случая
    //Даже если число пропущено в начале, будет суммировать все элементы(((
    private static int sumSearch(ArrayList<Integer> list) {
        System.out.println("поиск через сумму элементов");
        if (list.isEmpty()) {
            System.out.println("сработало 1 условие");
            return 1;
        }
        long target_sum = (long) (list.size() + 1) * (list.size() + 2) / 2;
        long real_sum = 0;
        for (Integer integer : list) {
            real_sum += integer;
        }
        return (int) (target_sum - real_sum);
    }

    //O(n) Выигрывает при лучших случаях
    private static int linearSearch(ArrayList<Integer> list) {
        System.out.println("линейный поиск пропущенного элемента");
        if (list.isEmpty() || list.get(0) != 1) {
            System.out.println("сработало 1 условие");
            return 1;
        }
        if (list.get(list.size() - 1) != list.size() + 1) {
            System.out.println("сработало 2 условие");
            return list.size() + 1;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != list.get(i - 1) + 1) {
                System.out.println("сработало 3 условие");
                return list.get(i) - 1;
            }
        }
        return 0;
    }

    private static ArrayList<Integer> generateArrayList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        int missed = (int)(Math.random() * (size + 1) + 1);
        for (int i = 1; i <= size + 1; i++) {
            if (i == missed) {
                continue;
            }
            list.add(i);
        }
        return list;
    }
}
