package ru.job4j.array;

/**
 * Calculate
 *
 * @author Alexey Bogutsky
 */
public class FindLoop {
    /**
     * @param data массив натуральных чисел
     * @param el   число для поиска
     * @return индекс в массиве найденного числа
     */
    public int indexOf(int[] data, int el) {
        int rst = -1; // если элемента нет в массиве, то возвращаем -1.
        for (int i = 0; i < data.length; i++) {
            if (data[i] == el) {
                rst = i;
                break;
            }
        }
        return rst;
    }
}