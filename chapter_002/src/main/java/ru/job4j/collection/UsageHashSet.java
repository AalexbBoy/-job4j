package ru.job4j.collection;

import java.util.HashSet;
/*
2. Добавьте в коллекцию autos марки машин: Lada, BMW, Volvo, Toyota.
3. Добавьте цикл for-each и выведите элементы коллекции HashSet на консоль.
*/
public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("Lada");
        autos.add("BMV");
        autos.add("Volvo");
        autos.add("Toyota");
        for (String brand : autos) {
            System.out.println(brand);
        }
    }
}
