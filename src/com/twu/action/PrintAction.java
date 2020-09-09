package com.twu.action;

import com.twu.TrendBoard;

public class PrintAction implements Action {
    private static final String name = "查看热搜排行榜";

    public String getName() {
        return name;
    }

    private final TrendBoard trendBoard = TrendBoard.getInstance();

    @Override
    public boolean execute() {
        System.out.println(trendBoard.display());
        return true;
    }
}
