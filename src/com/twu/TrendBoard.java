package com.twu;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrendBoard {
    private final Map<String, Trend> trends = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    private static final TrendBoard instance = new TrendBoard();

    public static TrendBoard getInstance() {
        return instance;
    }

    public boolean addTrend(String name, boolean isSuper) {
        if (trends.containsKey(name)) {
            return false;
        }
        trends.put(name, isSuper ? new SuperTrend(name) : new Trend(name));
        return true;
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
