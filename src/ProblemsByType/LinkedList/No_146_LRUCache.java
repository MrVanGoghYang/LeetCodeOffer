package ProblemsByType.LinkedList;

import java.util.*;

public class No_146_LRUCache
{
    // ˫�������㶨��
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
    // �洢Key��˫�������н��Ķ�Ӧ��ϵ
    Map<Integer, Node> map;
    // ʵ�ʴ�С
    int size;
    // �������
    int capacity;
    // ˫�������dumpy��ͷ�ͱ�β��ʼ�ձ��ֱ�ͷ��һ��Ϊ���ʹ��Ԫ�أ���βǰһ��Ϊ���δʹ��Ԫ��
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
    // �漰����˫������������ṩAPI��
    // 1. ��ͷ����Ԫ�أ� 2. ɾ��ĳ�����;  3.��ĳ������Ƶ���ͷ
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
    // ע�⣺�˷���������insertFirst��new Node��Ϊ�ᵼ��mapָ��һ��
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
