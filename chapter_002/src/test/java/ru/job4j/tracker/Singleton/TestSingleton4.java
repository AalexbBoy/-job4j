package ru.job4j.tracker.Singleton;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestSingleton4 {
    @Test
    public void WhenAddToOneGetFromSecond() {
        Tracker tracker1 = TrackerSingleton4.getInstance()
                .getTracker();
        Item item = new Item("test1", "testDescription", 9L);
        tracker1.add(item);
        Tracker tracker2 = TrackerSingleton4.getInstance()
                .getTracker();
        assertThat(tracker1, is(tracker2));
    }
}
