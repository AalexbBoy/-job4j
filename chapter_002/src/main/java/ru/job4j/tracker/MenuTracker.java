package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

import static ru.job4j.tracker.StartUI.*;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */

    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     * Композиция
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(ADD,"Добавление элемента"));
        this.actions.add(new ShowItems(SHOW,"Поиск всех заявок"));
        this.actions.add(new EditItem(EDIT,"Редактирование заявки"));
        this.actions.add(new DeleteItem(DEL,"Удаление заявки"));
        this.actions.add(new FindByID(FIND_ID,"Поиск по ID"));
        this.actions.add(new FindByName(FIND_NAME,"Поиск по названию"));
        this.actions.add(new ExitProgram(EXIT,"Выход",ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}