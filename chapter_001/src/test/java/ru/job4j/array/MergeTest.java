package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MergeTest {

    @Test
    public void whenMerge2x2() {
        int[] left = new int[]{1, 3};
        int[] right = new int[]{2, 4};
        Merge array = new Merge();
        int[] rst = array.merge(left, right);
        int[] expect = new int[]{1, 2, 3, 4};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenMerge3x3() {
        int[] left = new int[]{1, 3, 5};
        int[] right = new int[]{2, 4, 7};
        Merge array = new Merge();
        int[] rst = array.merge(left, right);
        int[] expect = new int[]{1, 2, 3, 4, 5, 7};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenMerge3x3WithEqual() {
        int[] left = new int[]{1, 3, 5};
        int[] right = new int[]{1, 4, 7};
        Merge array = new Merge();
        int[] rst = array.merge(left, right);
        int[] expect = new int[]{1, 1, 3, 4, 5, 7};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenMerge2x4WithEqual() {
        int[] left = new int[]{1, 3,};
        int[] right = new int[]{1, 4, 7, 8};
        Merge array = new Merge();
        int[] rst = array.merge(left, right);
        int[] expect = new int[]{1, 1, 3, 4, 7, 8};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenMerge4x2WithEqual() {
        int[] left = new int[]{1, 4, 7, 8};
        int[] right = new int[]{1, 3,};
        Merge array = new Merge();
        int[] rst = array.merge(left, right);
        int[] expect = new int[]{1, 1, 3, 4, 7, 8};
        assertThat(rst, is(expect));
    }
}


