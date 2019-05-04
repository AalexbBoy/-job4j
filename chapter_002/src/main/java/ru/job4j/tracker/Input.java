package ru.job4j.tracker;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> refs/remotes/origin/slave
/**
 * @version $Id$
 * @since 0.1
 */

interface Input {
    String ask(String question);
    int ask(String question, List<Integer> range)throws MenuOutException;
}
