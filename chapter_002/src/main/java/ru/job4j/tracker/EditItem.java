package ru.job4j.tracker;

public class EditItem extends BaseAction {
    public EditItem(String key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Редактирование заявки --------------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            Item newItem = new Item(input.ask("Введите новое имя заявки :"),
                    input.ask("Введите новое описание заявки :"), System.currentTimeMillis());
            newItem.setId(tracker.generateId());
            if (tracker.replace(id, newItem)) {
                System.out.println("Замена прошла успешно");
            } else {
                System.out.println("Замена не удалась");
            }

        } else {
            System.out.println("Нет такой заявки");
        }
    }
}
