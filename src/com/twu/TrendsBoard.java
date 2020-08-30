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

    public Trend getTrendByName(String name) {
        return trends.get(name);
    }
}
