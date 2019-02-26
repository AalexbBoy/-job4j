package ru.job4j.array;

/**
 * Вычисление квадратов чисел
 */

public class Square {
    /**
     * @param bound число
     * @return массив квадратов чисел
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }

        return rst;
    }
}

