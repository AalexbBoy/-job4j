package ru.job4j.search;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {

        return persons.stream().filter(
                person -> person.getName().contains(key) ||  person.getAddress().contains(key)||
                          person.getSurname().contains(key)||  person.getPhone().contains(key)
        ).collect(Collectors.toCollection(ArrayList::new));
    }
}
