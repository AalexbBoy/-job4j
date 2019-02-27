package ru.job4j.array;

/**
 * Талица умножения
 *
 * @author Alexey Bogutsky
 * @version $Id$
 * @since 0.1
 */
public class MatrixCheck {
    /**
     * @param data размер матрицы
     * @return true, если диагонали равны
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        int index = data.length;
        for (int i = 0; i < index; i++) {
            if ((data[i][i] != data[index - 1][index - 1]) || (data[index - i - 1][i] != data[i][i])) {
                result = false;
                break;
            }
        }
        return result;

    }
}