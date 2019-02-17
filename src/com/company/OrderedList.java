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
        /*Node after;
        Node before;
        if(head == null){   //если список пустой, новый узел становится головой и хвостом
            head = newNode;
            tail = newNode;
        }
        */
        // автоматическая вставка value
        // в нужную позицию

        if(head == null){       //если список пустой, новый узел становится его головой и хвостом
            head = newNode;
        }else if(compare(value, head.value)== -1 && _ascending){        //если новый узел меньше головы и списк возрастающий, новый ставится перед головой
            newNode.next = head;
            head = newNode;
        }else if(compare(value, head.value)== 1 && !_ascending){        //если новый узел больше и список убывающий, новый становится перед головой
            newNode.next = head;
            head = newNode;
        }
        else{

            Node<T> after = head.next;
            Node<T> before = head;

            while(after!= null){
                if(_ascending){
                    if (compare(value, after.value) == -1)
                        break;
                }else{
                    if (compare(value, after.value) == 1)
                        break;
                }
                before = after;
                after = after.next;
            }
            newNode.next = before.next;
            before.next = newNode;
        }
    }

    public Node<T> find(T val)
    {
        return null; // здесь будет ваш код
    }

    public void delete(T val)
    {
        // здесь будет ваш код
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        // здесь будет ваш код
    }

    public int count()
    {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void log(){

        Node tmp = head;
        if(head == null){
            System.out.println("empty list");
        }else{
            while(tmp != null){
                System.out.print(tmp.value+" ");
                tmp = tmp.next;
            }
        }
        System.out.println();
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
