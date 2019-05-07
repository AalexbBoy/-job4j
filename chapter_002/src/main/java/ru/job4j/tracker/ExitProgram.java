package ru.job4j.tracker;
/** Наследование
 */

public class ExitProgram extends BaseAction {
    private static StartUI sui;
    public ExitProgram(String key, String name,StartUI ui)
    {
        super(key, name);
        sui=ui;

    }

    @Override
    public void execute(Input input, Tracker tracker) {
    sui.StopProgram();
    }
}
