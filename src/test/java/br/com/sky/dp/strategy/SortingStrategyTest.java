package br.com.sky.dp.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class SortingStrategyTest {
    private static final List<Integer> lst = List.of(10,88,77,66,55,22,33,11,17,19);
    private Sorter sorter;

    @BeforeEach
    public void setUp() {
        sorter = new Sorter();
    }

    @Test
    public void sortAscending() {
        //given
        AscendingSorting strategy = new AscendingSorting();

        //when
        List<Integer> result = sorter.sort(lst, strategy);

        //then
        List<Integer> sorted = List.of(10,11,17,19,22,33,55,66,77,88);
        assertNotSame(sorted, lst);
        assertEquals(sorted, result);
    }

    @Test
    public void sortDescending() {
        //given
        DescendingSorting strategy = new DescendingSorting();

        //when
        List<Integer> result = sorter.sort(lst, strategy);

        //then
        List<Integer> sorted = List.of(88,77,66,55,33,22,19,17,11,10);
        assertNotSame(sorted, lst);
        assertEquals(sorted, result);
    }

    @Test
    public void sortEvenFirst() {
        //given
        EvenFirstSorting strategy = new EvenFirstSorting();

        //when
        List<Integer> result = sorter.sort(lst, strategy);

        //then
        List<Integer> sorted = List.of(10,22,66,88,11,17,19,33,55,77);
        assertNotSame(sorted, lst);
        assertEquals(sorted, result);
    }

    @Test
    public void sortOddFirst() {
        //given
        OddFirstSorting strategy = new OddFirstSorting();

        //when
        List<Integer> result = sorter.sort(lst, strategy);

        //then
        List<Integer> sorted = List.of(11,17,19,33,55,77,10,22,66,88);
        assertNotSame(sorted, lst);
        assertEquals(sorted, result);
    }

    @Test
    public void mixinAllSort() {
        //given
        AscendingSorting ascendingSorting = new AscendingSorting();
        DescendingSorting descendingSorting = new DescendingSorting();
        EvenFirstSorting evenFirstSorting = new EvenFirstSorting();
        OddFirstSorting oddFirstSorting = new OddFirstSorting();

        List<Integer> sortedAsc = List.of(10,11,17,19,22,33,55,66,77,88);
        List<Integer> sortedDesc = List.of(88,77,66,55,33,22,19,17,11,10);
        List<Integer> sortedEven = List.of(10,22,66,88,11,17,19,33,55,77);
        List<Integer> sortedOdd = List.of(11,17,19,33,55,77,10,22,66,88);

        //when
        List<Integer> resultAsc = sorter.sort(lst, ascendingSorting);
        List<Integer> resultDesc = sorter.sort(lst, descendingSorting);
        List<Integer> resultEven = sorter.sort(lst, evenFirstSorting);
        List<Integer> resultOdd = sorter.sort(lst, oddFirstSorting);

        //then
        assertNotSame(resultAsc, resultDesc);
        assertNotSame(resultDesc, resultEven);
        assertNotSame(resultEven, resultOdd);
        assertNotSame(resultOdd, resultAsc);

        assertEquals(sortedAsc, resultAsc);
        assertEquals(sortedDesc, resultDesc);
        assertEquals(sortedEven, resultEven);
        assertEquals(sortedOdd, resultOdd);
    }
}
