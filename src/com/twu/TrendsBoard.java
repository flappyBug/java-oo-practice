package com.twu;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TrendsBoard {
    private Set<Trend> trends;

    public void addTrending(String name) {
        this.trends.add(new Trend(name));
    }

    public List<Trend> getOrderedTrends() {
        return this.trends.stream().sorted().collect(Collectors.toList());
    }
}
