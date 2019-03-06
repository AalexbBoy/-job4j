package ru.job4j.loop;

/**
 * @author Alex.boy
 * @version $Id$
 * @since 0.1
 */
public class Board {
    /**
     * @param width  ширина доски
     * @param height высота доски
     * @return доска
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
