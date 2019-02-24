package ru.job4j.max;
/**
 * Программа расчета максимального числа.
 */
public class Max {
    /**
     * Расчет максимального числа.
     * @param first первое число
     * @param second второе число
     * @param third третье число
     * @return максимальное число.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}

