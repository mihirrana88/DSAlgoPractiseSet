package DS.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache3 {
    Node head = new Node(0, 0);
    Node trail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();
    int capacity;

    LRUCache3(int capacity){
        this.capacity = capacity;
        head.next = trail;
        trail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else {
            return -1;
        }
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(capacity == map.size()){
            remove(trail.prev);
        }

        insert(new Node(key, value));
    }

    void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void insert(Node node){
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
        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}



