package ru.job4j.array;

/**
 * Моно массив булевых значений
 *
 * @author alex.boy
 */
public class Check {
    /**
     * @param data булевый массив
     * @return True - если моно
     */

    public boolean mono(boolean[] data) {
        boolean result = false;
        int countTrue = 0;
        int countFalse = 0;

        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                countTrue += 1;
            } else {
                countFalse += 1;
            }
        }
        if (countTrue == data.length) {
            result = true;
        } else if (countFalse == data.length) {
            result = true;
        }
        return result;
    }
}