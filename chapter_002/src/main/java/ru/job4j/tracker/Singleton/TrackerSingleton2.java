package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

/**
 * Второй вариант singleton, static field.
 * Lazy loading.
 * @author Alex
 */
public class TrackerSingleton2 {
    private static TrackerSingleton2 instance;

    private TrackerSingleton2() {
    }

    public static TrackerSingleton2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingleton2();
        }
        return instance;
    }


    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}