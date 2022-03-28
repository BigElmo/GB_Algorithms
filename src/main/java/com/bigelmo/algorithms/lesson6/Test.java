package com.bigelmo.algorithms.lesson6;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int countBalanced = 0;
        int countTotal = 100;

        Random random = new Random();

        for (int i = 0; i < countTotal; i++) {
            Tree<Integer> tree = new TreeImpl<>();

            while (tree.height(tree.getRoot()) <= 4) {
                tree.add(random.nextInt(50) - 25);
            }

            if (tree.isBalanced(tree.getRoot())) {
                countBalanced += 1;
            }

            tree.display();
        }

        System.out.println("Count of balanced trees: " + countBalanced);
        System.out.println("Total trees: " + countTotal);
    }
}
