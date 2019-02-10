package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest  {
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubstractOneMinusOneThenZero()  {
        Calculator calc = new Calculator();
        calc.substract(1D, 1D);
        double result = calc.getResult();
        double expected = 0D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultiplyOneMultipleOneThenOne()  {
        Calculator calc = new Calculator();
        calc.multiply(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));

    }	  @Test
    public void whenDivideOneDivideOneThenOne()  {
        Calculator calc = new Calculator();
        calc.divide(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
}