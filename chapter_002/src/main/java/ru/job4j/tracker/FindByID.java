package ru.job4j.tracker;

public class FindByID extends BaseAction {
    public FindByID(String key, String name) {
        super(key, name);
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
