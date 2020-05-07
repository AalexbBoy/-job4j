package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = list.size() % cells == 0 ? list.size() / cells : list.size() / cells + 1;
        int[][] array = new int[groups][cells];
        int i=0;
        for (Integer num : list) {
            array[i/groups][i%cells] = num;
            i++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

