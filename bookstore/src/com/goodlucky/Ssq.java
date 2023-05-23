package com.goodlucky;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 12105
 */
public class Ssq {

    final static int RED = 33;
    final static int BLUE = 16;

    final static int RED_COUNT = 6;


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
            int temp = list1.get((int) (Math.random() * list1.size()));
            System.out.print(temp + "\t");
            list1.remove(Integer.valueOf(temp));
        }

        Thread.sleep(5000);

        System.out.print("+" + "\t");

        Thread.sleep(3000);
        int temp = list2.get((int) (Math.random() * list2.size()));
        System.out.print(temp + "\t");
        list2.remove(Integer.valueOf(temp));
    }
}
