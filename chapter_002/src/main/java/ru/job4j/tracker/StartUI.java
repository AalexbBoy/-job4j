package ru.job4j.tracker;

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DEL = "3";
    private static final String FIND_ID = "4";
    private static final String FIND_NAME = "5";


    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOW.equals(answer)) {
                this.showItems();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DEL.equals(answer)) {
                this.deleteItem();
            } else if (FIND_ID.equals(answer)) {
                this.findById();
            } else if (FIND_NAME.equals(answer)) {
                this.findByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, System.currentTimeMillis());
        if (this.tracker.add(item) != null) {
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        } else {
            System.out.println("Добавить не удалось");
        }
    }

    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            Item newItem = new Item(this.input.ask("Введите новое имя заявки :"),
                    this.input.ask("Введите новое описание заявки :"), System.currentTimeMillis());
            if (tracker.replace(id, newItem)) {
                System.out.println("Замена прошла успешно");
            } else {
                System.out.println("Замена не удалась");
            }

        } else {
            System.out.println("Нет такой заявки");
        }
    }


    private void showItems() {
        System.out.println("------------ Поиск всех заявок --------------");
        Item[] items = this.tracker.findAll();
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println("------------ Найдена заявка с именем : " + it.getName() + "-----------");
                System.out.println("------------ описание заявки :" + it.getDecs() + "-----------");
            }
        }
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            System.out.println("------------ Найдена заявка с именем : " + items[0].getName() + "-----------");
            System.out.println("------------ описание заявки :" + items[0].getDecs() + "-----------");
            if (tracker.delete(items[0].getId())) {
                System.out.println("Удаление прошло успешно");
            } else {
                System.out.println("Удаление не удалась");
            }
        } else {
            System.out.println("Нет такой заявки");
        }
    }

    private void findById() {
        System.out.println("------------ Поиск по ID заявки --------------");
        String id = this.input.ask("Введите ID заявки :");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("------------ Найдена заявка с именем : " + item.getName() + "-----------");
            System.out.println("------------ описание заявки :" + item.getDecs() + "-----------");
        } else {
            System.out.println("Нет такой заявки");
        }
    }

    private void findByName() {
        System.out.println("------------ Поиск по имени заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        if (items.length != 0) {
            for (Item it : items) {
                System.out.println("------------ Найдена заявка с именем : " + it.getName() + "-----------");
                System.out.println("------------ описание заявки :" + it.getDecs() + "-----------");
            }
        }
    }


    private void showMenu() {
        String str = String.join("\n", "Меню.", "0. Add new Item", "1. Show all items",
                "2. Edit item", "3. Delete item", "4. Find item by Id", "5. Find items by name",
                "6. Exit Program", "Select: ");
        System.out.println(str);
    }

    /**
     * Запускт программы.
     *
     * @param args параметры командной строки
     */
    public static void main(String[] args) {

        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}



