package com.bigelmo.algorithms.lesson2.comparators;

import com.bigelmo.algorithms.lesson2.Lesson2Main;
import com.bigelmo.algorithms.lesson2.Notebook;

import java.util.Comparator;

public class MakerComparator implements Comparator<Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        int o1Index = Lesson2Main.getMakers().indexOf(o1.getMaker());
        int o2Index = Lesson2Main.getMakers().indexOf(o2.getMaker());
        return o1Index - o2Index;
    }
}
