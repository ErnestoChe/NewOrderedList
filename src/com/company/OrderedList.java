package com.company;

import java.lang.reflect.ParameterizedType;
import java.util.*;


class Node<T>
{
    public T value;
    public Node<T> next, prev;
    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2)
    {
        if (v1 instanceof Integer && v2 instanceof Integer){
            if(((Integer) v1).intValue()<((Integer) v2).intValue()){
                return -1;
            }else if(((Integer) v1).intValue()>((Integer) v2).intValue()){
                return 1;
            }else return 0;
        }else return 0;
        //return 0;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value)
    {
        Node newNode = new Node(value);
        // автоматическая вставка value
        // в нужную позицию
        if(head == null){       //если список пустой, новый узел становится его головой и хвостом
            head = newNode;
            tail = newNode;
        }else if((compare(value, head.value)== -1 && _ascending ) || (compare(value, head.value)== 1 && !_ascending)){        //если новый узел меньше головы и списк возрастающий, новый ставится перед головой
            newNode.next = head;                                                                                              //если новый узел больше и список убывающий, новый становится перед головой
            head.prev = newNode;
            head = newNode;
        }else if((compare(value, tail.value) == 1 &&  _ascending) || (compare(value, tail.value) == -1 && !_ascending)){
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        else{
            Node<T> after = head;
            Node<T> before = head.next;
            while(before.next!= null){
                if(_ascending){
                    if (compare(value, after.value) == 1 && compare(value, before.value) == -1)   //value > after.value   value < before
                        break;
                }else{
                    if (compare(value, after.value) == -1 && compare(value, before.value) == 1)  //value < after.value      value > before
                        break;
                }
                after = before;
                before = before.next;
            }
            //System.out.println("adding " + value + " after "+ after.value + " before "+ before.value);
            newNode.next = before;
            newNode.prev = after;
            after.next = newNode;
            before.prev = newNode;
        }
    }

    public Node<T> find(T val)
    {

        Node tmp = head;
        while(tmp!= null && tmp.value != val){
            tmp = tmp.next;
        }
        return tmp;
        // здесь будет ваш код
    }

    public void delete(T val)
    {
        if(head == tail){
            head = null;
            tail = null;
        }else if(tail.value == val){
            tail = tail.prev;
            tail.next = null;
        }else if(head.value == val){
            head = head.next;
            head.prev = null;
        }else{
            Node key = find(val);
            if(key == null){
            }else{
                key.prev.next = key.next;
                key.next.prev = key.prev;
            }
        }
        // здесь будет ваш код
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        head = null;
        tail = null;
        // здесь будет ваш код
    }

    public int count()
    {
        Node temp = head;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.next;
        }
        return count;
        // здесь будет ваш код подсчёта количества элементов в списке
    }

    public boolean log(){

        Node tmp = head;
        boolean bool;
        if(head == null){
            System.out.println("empty list");
            bool = false;
        }else{
            bool = true;
            while(tmp != null){
                System.out.print(tmp.value+" ");
                tmp = tmp.next;
            }
        }
        System.out.println();
        return bool;
    }
    public boolean logBack(){
        Node tmp = tail;
        boolean bool;
        if(tail == null){
            System.out.println("empty list");
            bool = false;
        }else{
            bool = true;
            while(tmp != null){
                System.out.print(tmp.value+" ");
                tmp = tmp.prev;
            }
        }
        System.out.println();
        return bool;
    }

    public void logStat(){
        if(log()){
            System.out.println("head " + head.value);
            System.out.println("tail " + tail.value);
        }
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}
