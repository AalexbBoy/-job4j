package ru.job4j.array;

/**
 * Массив задом наперед
 *
 * @author alex.Boy
 */
public class Turn {
    /**
     * @param array входной массив
     * @return перевернутый массив
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        return array;
    }
}
