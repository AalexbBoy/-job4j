package ru.job4j.tracker;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     * Агрегация
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {

        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    public String generateId() {
        Date time = new Date();
        return (time.getTime() + "" + Math.random());
    }

    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                this.items.set(i, item);
                result = true;
                break;

            }
        }
        return result;
    }

    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                items.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    public List<Item> findAll() {
        List<Item> result = new ArrayList<>();
        if (items.size() == 0) {
            System.out.println("Нет заявок!");
        } else {
            result = this.items;
        }

        return result;
    }

    /**
     * проверяет в цикле все элементы массива this.items, сравнивая name
     * (используя метод getName класса Item) с аргументом метода String key. Элементы, у которых совпадает
     * name, копирует в результирующий массив и возвращает его;
     */

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }
}










