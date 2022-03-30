package ProblemsByType.LinkedList;

import java.util.*;

public class No_146_LRUCache
{
    // 双向链表结点定义
    class Node
    {
        int key;
        int val;
        Node next;
        Node pre;
        Node(){}
        Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }
    // 存储Key与双向链表中结点的对应关系
    Map<Integer, Node> map;
    // 实际大小
    int size;
    // 最大容量
    int capacity;
    // 双向链表的dumpy表头和表尾，始终保持表头后一个为最近使用元素，表尾前一个为最久未使用元素
    Node head, tail;

    No_146_LRUCache(int capacity)
    {
        this.map = new HashMap<>(capacity);
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.pre = head;
    }
    // 涉及到的双向链表操作，提供API：
    // 1. 表头插入元素； 2. 删除某个结点;  3.将某个结点移到表头
    public void insertFirst(Node ele)
    {
        ele.next = head.next;
        ele.next.pre = ele;
        head.next = ele;
        ele.pre = head;
    }
    public void delete(Node ele)
    {
        ele.pre.next = ele.next;
        ele.next.pre = ele.pre;
    }
    // 注意：此方法不可在insertFirst中new Node因为会导致map指向不一致
    public void moveToHead(Node ele)
    {
        delete(ele);
        insertFirst(ele);
    }
    public void printList()
    {
        Node q = head.next;
        for(int i = 0; i < size; i++)
        {
            System.out.print("[" + q.key + "," + q.val + "]  ");
            if(i == size - 1)
                System.out.println();
            q = q.next;
        }
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            moveToHead(node);
            // System.out.println("get " + key + " :");
            // printList();
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.val = value;
            moveToHead(node);
            // System.out.println("put(contains)  [" + key + "," + value + "] :");
            // printList();
        }
        else
        {
            Node insertNode = new Node(key, value);
            map.put(key, insertNode);
            insertFirst(insertNode);
            size++;
            // System.out.println("put(not contains && not full)  [" + key + "," + value + "] :");
            // printList();
            if(size > capacity)
            {
                map.remove(tail.pre.key);
                delete(tail.pre);
                size--;
                // System.out.println("put(not contains && full)  [" + key + "," + value + "] :");
                // printList();
            }
        }
    }
}
