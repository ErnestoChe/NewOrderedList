package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(3);
        ol.add(2);
        ol.add(5);
        ol.add(7);
        ol.add(4);
        ol.add(-1);
        ol.add(9);
        ol.logStat();
        //ol.logBack();
        ol.logNode();
        System.out.println("head.next = "+ ol.head.next.value);
        System.out.println("tail.prev = "+ ol.tail.prev.value);

        if(ol.head.prev == null){
            System.out.println("null");
        }else System.out.println("mistake" + ol.head.prev.value);

        if(ol.tail.next == null){
            System.out.println("null");
        }else System.out.println("mistake" + ol.tail.next.value);
    }
}
