package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String key() {
        return StartUI.DEL;
    }

    @Override
    public String info() {
        return "3.Delete Item.";
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
