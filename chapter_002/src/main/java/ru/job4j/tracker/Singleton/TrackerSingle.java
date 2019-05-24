package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerSingle {
    INSTANCE; // здесь мы указываем перечисления.
    private Tracker tracker = new Tracker();

    // Конструкторы и методы.
    public Tracker GetTracker() {

        return tracker;
    }
}

