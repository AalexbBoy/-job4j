package ru.job4j.converter;
/**
 * Корвертор валюты.
 */
// доллар = 60 рублей.
//1 евро = 70 рублей.
public class Converter {
    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return (value / 70);
    }
    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары
     */
    public int rubleToDollar(int value) {
        return (value / 60);
    }
	 /**
     * Конвертируем евро  в рубли.
     * @param value евро.
     * @return Рубли
     */
    public int evroToRuble(int value) {
        return (70 * value);
    }
    /**
     * Конвертируем доллары в рубли.
     * @param value доллары.
     * @return Рубли
     */
    public int dollarToRuble(int value) {
        return (value * 60);
    }
}
