package DS.LRUCache;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache2 {
    LinkedHashMap cache;
    public LRUCache2(int capacity) {
        cache = new LinkedHashMap(capacity, 1.0F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return this.size() > capacity;
            }
        };

    }

    public int get(int key) {
        return (int) cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
