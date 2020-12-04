package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));
        List<Student> expected = List.of(
                new Student("Pety", 128),
                new Student("Masha", 28)
        );
        assertThat(StudentLevel.levelOf(input, 20), is(expected));
    }
}
