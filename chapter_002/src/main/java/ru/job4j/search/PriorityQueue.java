package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставки использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (!this.tasks.isEmpty()) {
            if (this.tasks.getLast().getPriority() <= task.getPriority()) {
                this.tasks.add(this.tasks.size(), task);
            } else {
                for (Task element : tasks) {
                    if (task.getPriority() <= element.getPriority()) {
                        this.tasks.add(index, task);
                        break;
                    } else index++;
                }
                //if (index == this.tasks.size()) this.tasks.add(++index, task);
            }
        } else this.tasks.add(0, task);
    }

    public Task take() {
        return tasks.poll();
    }
}