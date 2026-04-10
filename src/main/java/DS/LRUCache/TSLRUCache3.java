package DS.LRUCache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class TSLRUCache3 {

    private final Node head = new Node(0, 0);
    private final Node trail = new Node(0, 0);
    private final Map<Integer, Node> map = new HashMap<>();
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();

    TSLRUCache3(int capacity) {
        this.capacity = capacity;
        head.next = trail;
        trail.prev = head;
    }

    public int get(int key) {
        lock.lock();
        try {
            if (!map.containsKey(key)) {
                return -1;
            }
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                remove(map.get(key));
            }

            if (map.size() == capacity) {
                remove(trail.prev);
            }

            insert(new Node(key, value));
        } finally {
            lock.unlock();
        }
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        map.put(node.key, node);
        Node latestNode = head.next;
        latestNode.prev = node;
        node.next = latestNode;
        head.next = node;
        node.prev = head;
    }

    class Node {
        Node prev;
        Node next;
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}