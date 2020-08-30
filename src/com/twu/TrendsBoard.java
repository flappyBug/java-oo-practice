package com.twu;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrendsBoard {
    private final Map<String, Trend> trends = new HashMap<>();

    public void addTrending(String name) {
        this.trends.put(name, new Trend(name));
    }

    public Stream<Trend> getOrderedTrends() {
        return this.trends.values().stream().sorted(Comparator.reverseOrder());
    }

    public String display() {
        return getOrderedTrends().map(Trend::display).collect(Collectors.joining("\n"));
    }

    public boolean voteFor(String name, int votes) {
        Trend trend = trends.get(name);
        if (trend == null) {
            return false;
        }
        trend.vote(votes);
        return true;
    }
}
