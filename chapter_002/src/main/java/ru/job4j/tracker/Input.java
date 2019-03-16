package ru.job4j.tracker;

import java.util.Scanner;

/**
 * @version $Id$
 * @since 0.1
 */

class Input {
    public String ask(String question) {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        return str;
    }
}
