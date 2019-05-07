package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *
 *
 * @author Alex.Boy
 * @version $Id$
 * @since 0.1
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"Не цифра", "1"})
        );
        List range=new  ArrayList<Integer>();
        range.add(0,1);
        input.ask("Выберите число из меню ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Вы ввели не число!%n")
                )
        );
    }

    @Test
    public void whenInputOutOfRange() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"9", "1"})
        );
        List range=new  ArrayList<Integer>();
        range.add(0,1);
        input.ask("Выберите число из меню ", range);
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Выберите число из меню%n")
                )
        );
    }
}