package ru.job4j.tracker;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

public class SortTest {
    @Test
    public void whenSortItemsInAsc() {
        Tracker tracker = new Tracker();
        List<Item> result = new ArrayList<>();
        Item item = new Item("test1", "testDescription", System.currentTimeMillis());
        tracker.add(item);
        item = new Item("test3", "testDescription3", System.currentTimeMillis());
        tracker.add(item);
        item = new Item("test2", "testDescription2", System.currentTimeMillis());
        tracker.add(item);
        List<Item> actual = tracker.findAll();
        actual.sort(new AscItemSorter());
        result.add(tracker.findByName("test1").get(0));
        result.add(tracker.findByName("test2").get(0));
        result.add(tracker.findByName("test3").get(0));
        assertThat( actual , is(result));
    }

        @Test
        public void whenSortItemsInDesc() {
            Tracker tracker = new Tracker();
            List<Item> result = new ArrayList<>();
            Item item = new Item("test1", "testDescription", System.currentTimeMillis());
            tracker.add(item);
            item = new Item("test3", "testDescription3", System.currentTimeMillis());
            tracker.add(item);
            item = new Item("test2", "testDescription2", System.currentTimeMillis());
            tracker.add(item);
            List<Item> actual = tracker.findAll();
            actual.sort(new AscItemSorter().reversed());
            result.add(tracker.findByName("test3").get(0));
            result.add(tracker.findByName("test2").get(0));
            result.add(tracker.findByName("test1").get(0));
            assertThat( actual , is(result));
        }
}
