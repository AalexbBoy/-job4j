package ru.job4j.search;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class testStreamApi {
    @Test
    public void whenListOfIntegerThenPositive() {
        StreamApi randomInt = new StreamApi();
        assertThat(randomInt.resList(randomInt.genList()), is(Arrays.asList(1, 2, 3, 4, 5)));
    }

}
