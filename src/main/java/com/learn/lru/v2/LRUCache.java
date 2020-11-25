package com.learn.lru.v2;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> cache = new HashMap<>();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        final Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        final Node node = cache.get(key);
        if (node == null) {
            final Node newNode = new Node(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            if (cache.size() > capacity) {
                cache.remove(removeTail().key);
            }
        } else {
            node.val = value;
            moveToHead(node);
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private static class Node {
        public int key;
        public int val;
        private Node prev;
        private Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private void print() {
        Node tmp = head.next;
        while (tmp.next != null) {
            System.out.print(tmp.val + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        final LRUCache lruCache = new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.print();

        lruCache.put(2, 2);
        lruCache.print();

        lruCache.get(1);
        lruCache.print();


        lruCache.put(3, 3);
        lruCache.print();

        lruCache.get(2);
        lruCache.print();

        lruCache.put(4, 4);
        lruCache.print();

        lruCache.get(1);
        lruCache.print();

        lruCache.get(3);
        lruCache.print();

        lruCache.get(4);
        lruCache.print();

    }
}
