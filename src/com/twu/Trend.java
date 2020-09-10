package com.twu;

import java.util.Objects;

public class Trend implements Comparable<Trend> {
    private final String name;
    private int votes = 0;

    Trend(String name) {
        this.name = name;
    }

    public void vote(int votes) {
        this.votes += votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trend)) return false;
        Trend trend = (Trend) o;
        return name.equalsIgnoreCase(trend.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }

    @Override
    public int compareTo(Trend o) {
        return votes - o.votes;
    }

    public String display() {
        return String.format("%s\t%d", name, votes);
    }

    public String getName() {
        return name;
    }
}
