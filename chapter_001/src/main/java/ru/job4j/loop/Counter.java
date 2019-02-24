package ru.job4j.loop;
/**
 * Программа расчета сумму четныx чисел.
 */
public class Counter {
    /**Метод должен вычислять сумму четныx чисел в диапазоне от start до finish;
     *
     * @param start с какого числа
     * @param finish по какое число
     * @return сумма
     */
    public int add(int start, int finish) {
        int sum = 0;

        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
