package ru.job4j.tracker.Singleton;

import static org.hamcrest.Matchers.is;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class TestSingleton {
    @Test
    public void WhenAddToOneGetFromSecond() {
        Tracker tracker1 = TrackerSingle.INSTANCE.GetTracker();
        Item item = new Item("test1", "testDescription", 9L);
        tracker1.add(item);
        Tracker tracker2 = TrackerSingle.INSTANCE.GetTracker();
        assertThat(tracker1, is(tracker2));
    }

}
