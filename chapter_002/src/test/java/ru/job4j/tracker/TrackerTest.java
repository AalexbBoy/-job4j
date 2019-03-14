package ru.job4j.tracker;


import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }


    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAllItemThenTrackerHasAllItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item[] result = new Item[2];
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        result[0] = item;
        item = new Item("test2", "testDescription2", 123L);
        tracker.add(item);
        result[1] = item;
        assertThat(tracker.findAll(), is(result));
    }

    @Test
    public void whenDelItemThenTrackerHasWithoutThisItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        String id = item.getId();
        tracker.delete(id);
        assertNull(tracker.findById(id));
    }

    @Test
    public void whenFindItemByStringThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item[] result = new Item[2];
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        item = new Item("test2", "testDescription2", 123L);
        tracker.add(item);
        result[0] = item;
        item = new Item("test2", "testDescription3", 1234L);
        tracker.add(item);
        result[1] = item;
        assertThat(tracker.findByName("test2"), is(result));
    }
}