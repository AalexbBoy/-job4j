package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException e) {
                System.out.println("Выберите число из меню");
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
            }
        } while (invalid);
        return value;
    }
}

class ConsoleInput implements Input {
    @Override
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) throws MenuOutException {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        boolean exist = false;
        int key = Integer.valueOf(scanner.nextLine());
        for (int value :
                range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) return key;
        else {
            throw new MenuOutException("Число не из меню");
        }
    }


}
