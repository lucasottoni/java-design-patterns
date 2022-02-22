package br.com.sky.dp.strategy;

import java.util.Comparator;
import java.util.List;

public class AscendingSorting implements SortingStrategy {
    @Override
    public List<Integer> sort(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
