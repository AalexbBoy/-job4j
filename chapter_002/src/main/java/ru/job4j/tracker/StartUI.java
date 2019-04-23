package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

interface UserAction {
    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    String key();

    /**
     * Основной метод.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    String info();
}

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    static final String ADD = "0";
    public static final String SHOW = "1";
    public static final String EDIT = "2";
    public static final String DEL = "3";
    public static final String FIND_ID = "4";
    public static final String FIND_NAME = "5";


    /**
     * Константа для выхода из цикла.
     */
    public static final String EXIT = "6";
    /**
     * Получение данных от пользователя.
     */

    private final Input input;
    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init()  {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }

        do {
            menu.show();
           try {
               menu.select(input.ask("select:", range));
           }
           catch (MenuOutException moe){
               System.out.println("MOE");
           }
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}



