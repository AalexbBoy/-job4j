package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final static String LF = System.lineSeparator();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserShowAllItemsThenTrackerGetAllItems() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name", "desc", System.currentTimeMillis())),
                tracker.add(new Item("test name 1", "desc 1", System.currentTimeMillis()))
        };
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        String estimated = new StringBuilder().append("------------ Поиск всех заявок --------------").append(LF)
                .append("------------ Найдена заявка с именем : test name-----------").append(LF)
                .append("------------ описание заявки :desc-----------").append(LF)
                .append("------------ Найдена заявка с именем : test name 1-----------").append(LF)
                .append("------------ описание заявки :desc 1-----------").append(LF).toString();
        Boolean result = out.toString().contains(estimated);
        assertThat(result, is(true));
    }

    @Test
    public void whenUserFindByNameTrackerHasItem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name", "desc", System.currentTimeMillis())),
                tracker.add(new Item("test name 1", "desc 1", System.currentTimeMillis()))
        };
        Input input = new StubInput(new String[]{"5", items[1].getName(), "6"});
        new StartUI(input, tracker).init();
        String estimated = new StringBuilder()
                .append("------------ Найдена заявка с именем : test name 1-----------").append(LF)
                .append("------------ описание заявки :desc 1-----------").append(LF).toString();
        Boolean result = out.toString().contains(estimated);
        assertThat(result, is(true));
    }

    @Test
    public void whenUserFindByIdTrackerHasItem() {
        Tracker tracker = new Tracker();
        Item[] items = {
                tracker.add(new Item("test name", "desc", System.currentTimeMillis())),
                tracker.add(new Item("test name 1", "desc 1", System.currentTimeMillis()))
        };
        items[1].setId("15529278633190.9486655021529988");
        Input input = new StubInput(new String[]{"4", items[1].getId(), "6"});
        new StartUI(input, tracker).init();
        String estimated = new StringBuilder()
                .append("------------ Найдена заявка с именем : test name 1-----------").append(LF)
                .append("------------ описание заявки :desc 1-----------").append(LF).toString();
        Boolean result = out.toString().contains(estimated);
        assertThat(result, is(true));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test replace"));
    }

    @Test
    public void whenUserDelItemThenTrackerHasNoThisItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc", System.currentTimeMillis()));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(0));

    }
}
