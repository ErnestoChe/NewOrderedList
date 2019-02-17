package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(2);
        System.out.println(ol.head.value);
        //System.out.println(ol.tail.value);
        //System.out.println(ol.compare(ol.head.value, ol.tail.value));
        ol.add(4);
        ol.add(1);
        ol.add(5);
        ol.add(5);
        ol.add(3);
        ol.add(7);
        ol.log();
    }
}
