package com.twu;

public class Main {



    public static void main(String[] args) {
        Session session = new Session();
        //noinspection InfiniteLoopStatement
        while (true) {
            session.chooseAction();
        }
    }
}
