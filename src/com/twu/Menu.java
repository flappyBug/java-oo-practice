package com.twu;

import com.twu.action.Action;

import java.util.stream.IntStream;

public abstract class Menu {
    private final Action[] actions;

    protected Menu(Action[] action) {
        this.actions = action;
    }

    public void printMenu() {
        IntStream.range(0, actions.length).forEach(
                index -> System.out.println(index + 1 + ". " + actions[index].getName())
        );
    }

    public void chooseAction(int index) {
        if (index < 1 || index > actions.length) {
            System.out.printf("请输入不大于%d的正整数所谓命令索引%n", actions.length);
            return;
        }
        actions[index - 1].execute();
    }
}
