package ru.job4j.tracker;

/**
 * Наследование
 */
public class AddItem extends BaseAction {

    public AddItem(String key, String name) {
        super(key, name); }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = input.ask("Введите название:");
        String desc = input.ask("Введите описание:");
        Item item = new Item(name, desc, System.currentTimeMillis());
        tracker.add(item);
        System.out.println("------------ Новая заявка Id : " + item.getId());
    }
}

