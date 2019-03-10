
package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] strArray = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDup.remove(strArray);
        String[] except = {"Привет", "Мир", "Супер"};
        assertThat(result, is(arrayContainingInAnyOrder(except)));
    }

    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateEven() {
        ArrayDuplicate arrayDup = new ArrayDuplicate();
        String[] strArray = {"Привет", "Супер", "Мир", "Привет", "Супер", "Мир"};
        String[] result = arrayDup.remove(strArray);
        String[] except = {"Привет", "Мир", "Супер"};
        assertThat(result, is(arrayContainingInAnyOrder(except)));
    }
}

