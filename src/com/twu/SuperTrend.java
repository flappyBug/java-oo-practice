package com.twu;

public class SuperTrend extends Trend {
    SuperTrend(String name) {
        super(name);
    }

    @Override
    public void vote(int votes) {
        super.vote(2 * votes);
    }
}
