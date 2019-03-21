import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity);
    }

    public void move_to_end(int key) {
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
    }

    public void remove_first() {
        cache.remove(cache.entrySet().iterator().next().getKey());
    }

    public int get(int key) {
        if (! cache.containsKey(key)) return -1;
        move_to_end(key);
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) move_to_end(key);
        cache.put(key, value);
        if (cache.size() == capacity + 1) remove_first();
    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(1, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }

}
