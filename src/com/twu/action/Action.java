package com.twu.action;

public interface Action {

    /**
     * Every action should have a name to display in context menu.
     * @return Action name
     */
    String getName();

    /**
     * Execute action interactively via standard IO.
     * @return Indicates whether the action was executed successfully.
     */
    boolean execute();
}
