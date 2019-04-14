package ru.job4j.tracker;

public class FindByID implements UserAction {
    @Override
    public String key() {
        return StartUI.FIND_ID;
    }

    @Override
    public String info() {
        return "4.Find by ID.";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск по ID заявки --------------");
        String id = input.ask("Введите ID заявки :");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Найдена заявка с именем : " + item.getName() + "-----------");
            System.out.println("------------ описание заявки :" + item.getDesc() + "-----------");
        } else {
            System.out.println("Нет такой заявки");
        }
    }
}
