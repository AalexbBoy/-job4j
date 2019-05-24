package ru.job4j.tracker.Singleton;

import ru.job4j.tracker.Tracker;

/**
 * Третий вариант singleton, static final field.
 * Eager loading.
 * @author Alex
 */
public class TrackerSingleton3 {
    private static final TrackerSingleton3 INSTANCE = new TrackerSingleton3();

    private TrackerSingleton3() {
    }

    public static TrackerSingleton3 getInstance() {
        return INSTANCE;
    }

    private Tracker tracker = new Tracker();

    public Tracker getTracker() {
        return tracker;
    }
}