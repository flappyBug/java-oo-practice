package com.twu;

public class Main {



    public static void main(String[] args) {
        Session session = Session.getInstance();
        session.printMenu();
//        TrendBoard trendBoard = TrendBoard.getInstance();
//        int votesRemain = 10;
//        boolean quit = false;
//
//        final String options = "1. 查看热搜排行榜\n" +
//                "2. 给热搜事件投票\n" +
//                "3. 购买热搜\n" +
//                "4. 添加热搜\n" +
//                "5. 退出";
//        Input input = Input.getInstance();
//        while (!quit) {
//            System.out.println(options);
//            int action;
//            action = input.getInteger().
//            try {
//                action = Integer.parseInt(scanner.nextLine().trim());
//            } catch (NumberFormatException e) {
//                System.out.println("无效输入，请输入数字索引");
//                continue;
//            }
//
//            switch (action) {
//                case ACT_PRINT:
//                    System.out.println(trendBoard.display());
//                    break;
//                case ACT_VOTE:
//                    System.out.println("请输入你要投票的热搜名称：");
//                    String trendName = input.getString();
//                    Trend trend = trendBoard.getTrendByName(trendName);
//                    if (trend == null) {
//                        System.out.println("投票失败：无此热搜");
//                        break;
//                    }
//                    System.out.println("请输入你要投的票数：（你目前还有" + votesRemain + "票)");
//                    try {
//                        int votes = Integer.parseInt(scanner.nextLine());
//                        if (votes > votesRemain || votes <= 0) {
//                            System.out.println("投票失败");
//                            break;
//                        }
//                        trend.vote(votes);
//                        votesRemain -= votes;
//                    } catch (NumberFormatException e) {
//                        System.out.println("投票失败");
//                    }
//                    break;
//                case ACT_BIDDING:
//                    throw new UnsupportedOperationException("Not implemented, yet");
//                case ACT_ADD:
//                    System.out.println("请输入你要添加的热搜事件的名字：");
//                    String name = scanner.nextLine().trim();
//                    trendBoard.addTrending(name);
//                    System.out.println("添加成功");
//                    break;
//                case ACT_QUIT:
//                    quit = true;
//                    break;
//                default:
//                    System.out.println("无效索引，请重新输入");
//            }
//        }
    }
}
