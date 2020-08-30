package com.twu;

import java.util.Scanner;


public class Main {
    private static final int ACT_PRINT = 1;
    private static final int ACT_VOTE = 2;
    private static final int ACT_BIDDING = 3;
    private static final int ACT_ADD = 4;
    private static final int ACT_QUIT = 5;


    public static void main(String[] args) {
        TrendsBoard trendsBoard = new TrendsBoard();
        boolean quit = false;
        final String options = "1. 查看热搜排行榜\n" +
                "2. 给热搜事件投票\n" +
                "3. 购买热搜\n" +
                "4. 添加热搜\n" +
                "5. 退出";
        Scanner scanner = new Scanner(System.in);
        while (!quit) {
            System.out.println(options);
            int action;
            try {
                action = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("无效输入，请输入数字索引");
                continue;
            }

            switch (action) {
                case ACT_PRINT:
                case ACT_VOTE:
                case ACT_BIDDING:
                case ACT_ADD:
                    throw new UnsupportedOperationException("Not implemented, yet");
                case ACT_QUIT:
                    quit = true;
                    break;
                default:
                    System.out.println("无效索引，请重新输入");
            }
        }
    }
}
