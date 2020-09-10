package com.twu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TrendBoard {
    private final Map<String, Trend> trends = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    // A bi-directional map between rank and trend
    private final BiMap<Integer, Trend> biddingTrends = new BiHashMap<>();
    // A map from rank to price
    private final Map<Integer, Integer> biddingPrices = new HashMap<>();
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

    public boolean bidFor(Trend trend, int rank, int price) {
        if (rank < 1 || rank > trends.size()) {
            return false;
        }

        Integer prevTrendRank = biddingTrends.inverse().get(trend);
        Integer prevRankPrice = biddingPrices.get(rank);
        if (prevRankPrice != null && prevRankPrice >= price) {
            return false;
        }

        if (prevTrendRank != null) {
            biddingPrices.remove(prevTrendRank);
            biddingTrends.remove(prevTrendRank);
        }

        biddingPrices.put(rank, price);
        Trend trendToDelete = biddingTrends.put(rank, trend);
        if (trendToDelete != null) {
            trends.remove(trendToDelete.getName());
        }
        return true;
    }
}
