package ru.job4j.array;

public class Merge {
    int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int j = 0, aLength;
        if (left.length <= right.length) {
            aLength = left.length;
        } else {
            aLength = right.length;
            int[] tmp = left;
            left = right;
            right = tmp;
        }
        for (int i = 0; i < aLength; i++) {
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
        if (j == result.length) {
            return result;
        } else {
            for (int i = left.length; i < right.length; i++, j++) {
                result[j] = right[i];
            }
            return result;
        }
    }
}
