package com.bigelmo.algorithms.lesson2.comparators;

import com.bigelmo.algorithms.lesson2.Notebook;

import java.util.Comparator;

public class RamComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        return o1.getRam().compareTo(o2.getRam());
    }
}
