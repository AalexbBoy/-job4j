package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
    boolean exitProgram = false;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     *                Композиция
     */

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        List<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }

        do {
            menu.show();
            try {

                menu.select(input.ask("Выберите:", range));
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } while (!exitProgram);
    }

    public void StopProgram() {
        this.exitProgram = true;
    }

    /**
     * Запускт программы.
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()),
                new Tracker()).init();
    }
}



