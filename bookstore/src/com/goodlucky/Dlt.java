package com.goodlucky;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12105
 */
public class Dlt {

    final static int RED = 35;
    final static int BLUE = 12;

    final static int RED_COUNT = 5;

    final static int BLUE_COUNT = 2;

    public static void main(String[] args) throws InterruptedException {

        List<Integer> list1 = new ArrayList<>();

        for (int i = 1; i <= RED; i++) {
            list1.add(i);
        }

        List<Integer> list2 = new ArrayList<>();

        for (int i = 1; i <= BLUE; i++) {
            list2.add(i);
        }

        for (int i = 0; i < RED_COUNT; i++) {
            Thread.sleep(3000);
            int temp = list1.get((int)(Math.random()*list1.size()));
            System.out.print(temp+"\t");
            list1.remove(Integer.valueOf(temp));
        }

        Thread.sleep(5000);

        System.out.print("+"+"\t");

        for (int i = 0; i < BLUE_COUNT; i++) {
            Thread.sleep(3000);
            int temp = list2.get((int) (Math.random() * list2.size()));
            System.out.print(temp + "\t");
            list2.remove(Integer.valueOf(temp));
        }
    }
}
