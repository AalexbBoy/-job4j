package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String key() {
        return StartUI.FIND_NAME;
    }

    @Override
    public String info() {
        return "5.Find by Name.";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск по имени заявки --------------");
        String name = input.ask("Введите имя заявки :");
        Item[] items = tracker.findByName(name);
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println("------------ Найдена заявка с именем : " + it.getName() + "-----------");
                System.out.println("------------ описание заявки :" + it.getDesc() + "-----------");
            }
        }
    }
}
