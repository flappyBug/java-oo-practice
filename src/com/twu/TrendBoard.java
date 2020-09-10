package com.twu;

import java.util.*;

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

    public List<Trend> getRankedTrends() {
        int maxRank = trends.size();
        List<Trend> rankedTrends = new ArrayList<>(trends.size());
        Map<Trend, Integer> invertedMap = biddingTrends.inverse();
        Iterator<Trend> orderedFreeTrends = trends.values().stream()
                .filter(trend -> !invertedMap.containsKey(trend))
                .sorted(Comparator.reverseOrder()).iterator();
        Iterator<Trend> orderedOutOfRankBiddingTrends = biddingTrends.values().stream()
                .filter(trend -> invertedMap.get(trend) > maxRank)
                .sorted(Comparator.reverseOrder()).iterator();

        for (int rank = 1; rank <= trends.size(); rank++) {
            Trend nextTrend = biddingTrends.get(rank);
            if (nextTrend != null) {
                rankedTrends.add(nextTrend);
                continue;
            }
            if (!orderedFreeTrends.hasNext()) {
                break;
            }
            rankedTrends.add(orderedFreeTrends.next());
        }
        while (orderedOutOfRankBiddingTrends.hasNext()) {
            rankedTrends.add(orderedOutOfRankBiddingTrends.next());
        }
        return rankedTrends;
    }

    public String display() {
        if (trends.isEmpty()) {
            return "排行榜为空\n";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("排名\t事件\t热度\n");
        List<Trend> rankedTrends = getRankedTrends();
        for (int i = 0; i < rankedTrends.size(); i++) {
            stringBuilder.append(i + 1)
                    .append('\t')
                    .append(rankedTrends.get(i).display())
                    .append('\n');
        }
        return stringBuilder.toString();
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
