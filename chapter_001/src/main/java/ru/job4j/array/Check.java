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
        boolean result = true;


        for (int i = 0; i < data.length; i++) {
            if (data[0] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}