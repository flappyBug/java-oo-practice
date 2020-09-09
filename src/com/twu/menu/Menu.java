package com.twu.menu;

import com.twu.Input;
import com.twu.action.Action;

import java.util.stream.IntStream;

public abstract class Menu {
    private final Action[] actions;

    protected Menu(Action[] action) {
        this.actions = action;
    }

    public void printWelcomeMessage() {}

    public void printMenu() {
        IntStream.range(0, actions.length).forEach(
                index -> System.out.println(index + 1 + ". " + actions[index].getName())
        );
    }

    public void chooseAction() {
        Input input = Input.getInstance();
        String errPrompt = String.format("请输入不大于%d的正整数所谓命令索引\n", actions.length);
        Integer index = input.getIntegerUntilSuccess(errPrompt, errPrompt, errPrompt,
                num -> num > 0 && num <= actions.length);
        actions[index - 1].execute();
    }
}
