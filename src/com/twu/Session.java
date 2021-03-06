package com.twu;

import com.twu.menu.LoginMenu;
import com.twu.menu.Menu;
import com.twu.user.Role;

import java.util.Stack;

public class Session {
    private Role role;
    private final TrendBoard trendBoard;
    private final Stack<Menu> menuStack = new Stack<>();

    public Session() {
        trendBoard = TrendBoard.getInstance();
        pushMenu(new LoginMenu(this));
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void pushMenu(Menu menu) {
        menuStack.push(menu);
    }

    public void popMenu() {
        menuStack.pop();
        if (menuStack.empty()) {
            System.out.println("再见！");
            System.exit(0);
        }
    }

    public void chooseAction() {
        Menu currentMenu = menuStack.peek();
        currentMenu.printWelcomeMessage();
        currentMenu.printMenu();
        currentMenu.chooseAction();
    }

    public TrendBoard getTrendBoard() {
        return trendBoard;
    }
}
