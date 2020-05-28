package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int lim = Math.min(left.length(), right.length());
        int rsl = Integer.compare(left.length(), right.length());
        for (int i = 0; i < lim; i++) {
            int charCmp = Character.compare(left.charAt(i), right.charAt(i));
            if (charCmp != 0) {
                rsl = charCmp;
                break;
            }
        }
        return rsl;
    }
}
