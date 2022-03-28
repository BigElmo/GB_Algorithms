package com.bigelmo.algorithms.lesson5.backpack;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Backpack {
    private int maxWeight;
    private ArrayList<Item> bestSelection;
    private int weight;
    private int cost;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
        bestSelection = new ArrayList<>();
        weight = 0;
        cost = 0;
    }

    public int checkCost(ArrayList<Item> selection) {
        int cost = 0;
        for (Item item : selection) {
            cost += item.getCost();
        }
        return cost;
    }

    public void showItems() {
        System.out.println("The backpack contains:");
        for (Item item : bestSelection) {
            System.out.println(item.getName() + " - " + item.getCost());
        }
        System.out.println("Total cost: " + cost);
        System.out.println("Total weight: " + weight);
    }

    public void select(ArrayList<Item> items) {
        if (checkWeight(items) <= maxWeight) {
            if (checkCost(items) > cost) {
                bestSelection = items;
                weight = checkWeight(bestSelection);
                cost = checkCost(bestSelection);
            }
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            ArrayList<Item> selection = new ArrayList<>();
            for (int j = 0; j < items.size() - 1; j++) {
                selection.add(items.get(j));
            }
            select(selection);
            rotate(items);
        }
    }

    private void rotate(ArrayList<Item> items) {
        Item temp = items.get(0);
        for (int i = 0; i < items.size() - 1; i++) {
            items.set(i, items.get(i + 1));
        }
        items.set(items.size() - 1, temp);
    }

    private int checkWeight(ArrayList<Item> selection) {
        int weight = 0;
        for (Item item : selection) {
            weight += item.getWeight();
        }
        return weight;
    }
}
