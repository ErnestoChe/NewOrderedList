package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(2);
        ol.add(4);
        ol.add(1);
        ol.add(5);
        ol.add(5);
        ol.add(3);
        ol.add(7);
        ol.logStat();
        System.out.println(ol.head.next.value);
        System.out.println(ol.tail.prev.value);

        if(ol.head.prev == null){
            System.out.println("null");
        }else System.out.println("mistake");

        if(ol.tail.next == null){
            System.out.println("null");
        }else System.out.println("mistake");

        System.out.println("count" + ol.count());

        int a = ol.find(5).value;
        System.out.println(a);
        System.out.println(ol.find(5).next.value);
        System.out.println(ol.find(5).prev.value);

        ol.delete(5);
        ol.logStat();

        //ol.clear(true);

        ol.logStat();

        ArrayList al = ol.getAll();

        System.out.println(al.get(0));
        System.out.println(al.get(al.size()-1));
    }
}
