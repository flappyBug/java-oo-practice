package com.twu.action;

import com.twu.Input;
import com.twu.Session;
import com.twu.Trend;
import com.twu.user.User;

import java.util.Optional;

public class VoteAction implements Action {
    public static final String name = "给热搜事件投票";
    private final Session session;

    public VoteAction(Session session) {
        this.session = session;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean execute() {
        Input input = Input.getInstance();
        System.out.println("请输入您要投票的热搜名称：");
        String trendName =  input.getString();
        Trend trend = session.getTrendBoard().getTrendByName(trendName);
        if (trend == null) {
            System.out.println("投票失败：无此热搜");
            return false;
        }
        User user = (User)session.getRole();
        System.out.println("请输入您要投的票数：（您目前还有" + user.getVotesRemain() + "票）");
        Optional<Integer> optionalVotes = input.getInteger("请输入票数：");
        if (optionalVotes.isEmpty()) {
            System.out.println("投票失败：输入不是整数");
            return false;
        }
        int votes = optionalVotes.get();
        if (votes < 1) {
           System.out.println("投票失败：请输入正整数");
           return false;
        }
        if (votes > user.getVotesRemain()) {
            System.out.println("投票失败：票数不足");
            return false;
        }
        user.voteFor(trend, votes);
        System.out.println("投票成功！");
        return true;
    }
}
