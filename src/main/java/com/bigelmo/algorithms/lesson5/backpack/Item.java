package com.bigelmo.algorithms.lesson5.backpack;

import lombok.Data;

@Data
public class Item {
    private String name;
    private int weight;
    private int cost;

    public Item(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }
}
