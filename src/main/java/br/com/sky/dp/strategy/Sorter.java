package br.com.sky.dp.strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Sorter nao precisa de alteracao por conta do comportamento
 */
public class Sorter {

    public List<Integer> sort(List<Integer> lst, SortingStrategy strategy) {
        List<Integer> toSort = new ArrayList<>(lst);
        return strategy.sort(toSort);
    }
}
