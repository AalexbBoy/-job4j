package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distanceToTest() {
        Point a = new Point(1, 1);
        Point b = new Point(3, 3);
        double result = a.distanceTo(b);
        assertThat(result, closeTo(2.8, 0.1));
    }
}