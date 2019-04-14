package ru.job4j.tracker;

public class ShowItems implements UserAction {
    @Override
    public String key() {
        return StartUI.SHOW;
    }

    @Override
    public String info() {
        return "1.Show Items.";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Поиск всех заявок --------------");
        Item[] items = tracker.findAll();
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println("------------ Найдена заявка с именем : " + it.getName() + "-----------");
                System.out.println("------------ описание заявки :" + it.getDesc() + "-----------");
            }
        } else System.out.println("------------ Нет заявок" + "-----------");
    }
}
