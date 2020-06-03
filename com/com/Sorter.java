package com;
// не информативное название пакета

import java.util.*;

/*
 * Нет описания класса
 */
public class Sorter {

    public Sorter(){

    }

    /*
     * Нет описания методов
     */
    Set<User> sort (List<User> list) {
        TreeSet<User> sortedList = new TreeSet<>();
        sortedList.addAll(list);
        return sortedList;
    }
    /*Не используется Кэмел именование  */
    List<User> sortnamelength (List<User> list) {
        Comparator<User> compar = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
            }
        };
        list.sort(compar);
        return list;
    }
    /*Не используется Кэмел именование  */
    List<User> sortboth (List<User> list) {
        //ничего не говорящие имена методов
        Comparator<User> compar1 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        //ничего не говорящие имена методов
        Comparator<User> compar2 = new Comparator<User>() {
            @Override
            public int compare (User o1, User o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        list.sort(compar1.thenComparing(compar2));
        return list;
    }
}