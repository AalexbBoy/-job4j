package ru.job4j.loop;

/**
 * Программа вычисления факториала
 */
public class Factorial {
    /**
     *
     * @param n Число для вычисления
     * @return факториал
     */
    public int calc(int n) {
        int multiplay = 1;
        for (int i = 1; i <= n; i++) {
            multiplay = multiplay * i;
        }
        return  multiplay;
    }
}
