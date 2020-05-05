package ru.job4j.tracker;


import java.util.List;


/**
 * @version $Id$
 * @since 0.1
 */

interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range);//throws MenuOutException;
}
