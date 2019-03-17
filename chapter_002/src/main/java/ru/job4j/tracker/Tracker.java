package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Date;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (position == 99) {
            item = null;
            System.out.println("Нет места для заявок");
        } else {
            item.setId(this.generateId());
            this.items[this.position++] = item;
        }
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Date time = new Date();
        return (time.getTime() + "" + Math.random());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                System.arraycopy(this.items, i + 1, this.items, i, position);
                this.items[--position] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public Item[] findAll() {
        Item[] result = new Item[position];
        if (position == 0) {
            System.out.println("Нет заявок!");
        } else {
            System.arraycopy(this.items, 0, result, 0, position);
        }
        return result;
    }

    /**
     * проверяет в цикле все элементы массива this.items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key. Элементы, у которых совпадает
     * name, копирует в результирующий массив и возвращает его;
     */

    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int j = 0;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getName().equals(key)) {
                result[j] = this.items[i];
                j++;
            }
        }
        return Arrays.copyOf(result, j);
    }

    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (this.items[i].getId().equals(id)) {
                result = this.items[i];
                break;
            }
        }
        return result;
    }
}















