package ru.job4j.tracker;

public class ExitProgram implements UserAction {
    @Override
    public String key() {
        return StartUI.EXIT;
    }

    @Override
    public String info() {
        return "6.Exit program.Press \"y\"";
    }


    @Override
    public void execute(Input input, Tracker tracker) {


    }
}
