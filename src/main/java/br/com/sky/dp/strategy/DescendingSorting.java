package br.com.sky.dp.strategy;

import java.util.Comparator;
import java.util.List;

public class DescendingSorting implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        list.sort(Comparator.reverseOrder());
        return list;
    }
}
