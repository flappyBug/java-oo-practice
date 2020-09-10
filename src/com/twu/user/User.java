package com.twu.user;

import com.twu.Trend;

public class User extends Role {

    private int votesRemain = 10;

    public User(String name) {
        super(name);
    }

    public int getVotesRemain() {
        return votesRemain;
    }

    // Skip votes check here.
    // It caller's responsibility to ensure the number of votes are valid.
    public void voteFor(Trend trend, int votes) {
        trend.vote(votes);
        votesRemain -= votes;
    }
}
