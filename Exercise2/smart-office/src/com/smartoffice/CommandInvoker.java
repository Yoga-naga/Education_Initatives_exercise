package com.smartoffice;

import java.util.ArrayList;
import java.util.List;

public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public void execute(Command cmd) {
        cmd.execute();
        history.add(cmd);
    }

    public List<Command> getHistory() {
        return history;
    }
}
