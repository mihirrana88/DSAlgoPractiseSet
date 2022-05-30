package DS.LRUCache;

import java.util.LinkedHashMap;

public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<Integer, Integer>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);

        if (map.size() > cap) {
            map.remove(map.keySet().iterator().next());
        }
    }
}
