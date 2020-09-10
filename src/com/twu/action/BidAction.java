package com.twu.action;

import com.twu.Input;
import com.twu.Session;
import com.twu.Trend;
import com.twu.TrendBoard;

public class BidAction implements Action {
    public static final String name = "购买热搜";
    private final Session session;

    public BidAction(Session session) {
        this.session = session;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        Input input = Input.getInstance();
        TrendBoard trendBoard = session.getTrendBoard();
        System.out.println("请输入你要购买的热搜名称：");
        String trendName = input.getString();
        Trend trend = trendBoard.getTrendByName(trendName);
        if (trend == null) {
            System.out.println("购买失败：不存在该热搜");
            return false;
        }
        System.out.println("请输入你要购买的热搜排名：");
        String errPrompt = "请输入数字：";
        int rank = input.getIntegerUntilSuccess(errPrompt, errPrompt);
        System.out.println("请输入你要购买的热搜金额：");
        int price = input.getIntegerUntilSuccess(errPrompt, errPrompt);
        boolean success = trendBoard.bidFor(trend, rank, price);
        if (!success) {
            System.out.println("购买失败");
            return false;
        }
        System.out.println("购买成功！");
        return true;
    }
}
