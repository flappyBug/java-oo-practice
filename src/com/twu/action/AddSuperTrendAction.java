package com.twu.action;

import com.twu.Input;
import com.twu.Session;

public class AddSuperTrendAction implements Action {
    private static final String name = "添加超级热搜";
    private final Session session;

    public AddSuperTrendAction(Session session) {
        this.session = session;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        Input input = Input.getInstance();
        System.out.println("请输入您要添加的超级热搜事件的名字：");
        String name = input.getString();
        if (session.getTrendBoard().addTrend(name, true)) {
            System.out.println("添加成功");
            return true;
        }
        System.out.println("添加失败：热搜已存在");
        return false;
    }
}
