package ru.job4j.tracker;

public class DeleteItem extends BaseAction {
    public DeleteItem(String key, String name) {
        super(key, name);
    }

    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки :");
        if (tracker.delete(id)) {
            System.out.println("Удаление успешно");
        } else {
            System.out.println("Удаление  не удалось");
        }
    }
}
