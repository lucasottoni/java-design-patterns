package br.com.sky.dp.strategy;

import java.util.List;

public class EvenFirstSorting implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        list.sort(this::compare);
        return list;
    }

    private int compare(Integer a, Integer b) {
        if (a % 2 == 0 && b % 2 == 0) return a.compareTo(b);
        if (a % 2 != 0 && b % 2 != 0) return a.compareTo(b);
        if (a % 2 == 0) return -1;
        return 1;
    }
}
