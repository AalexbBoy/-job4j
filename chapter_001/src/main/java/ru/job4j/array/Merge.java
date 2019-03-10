package ru.job4j.array;

public class Merge {
    int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length * 2];
        int j = 0;
        for (int i = 0; i < left.length; i++) {
            if (left[i] <= right[i]) {
                result[j] = left[i];
                result[j + 1] = right[i];
                j += 2;
            } else {
                result[i] = right[i];
                result[i + 1] = left[i];
                j += 2;
            }
        }
        return result;
    }
}
