146. LRU Cache
Description
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.

Example 1:

Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:

1 <= capacity <= 3000
0 <= key <= 104
0 <= value <= 105
At most 2 * 105 calls will be made to get and put.

Solution (NOTE: Replace both Deque/Map with LinkedList(DLL) for better performance).
class LRUCache {
    int CAPACITY;
    Deque<Integer> deque;
    Map<Integer, Integer> map;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        deque = new LinkedList<>();
        map = new HashMap<>();
    }
    
    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);
            value = map.get(key); 
        }
        return value;        
    }
    
    public void put(int key, int value) {
         if (!map.containsKey(key)) {
            if (CAPACITY == deque.size()) {
                int k = deque.removeLast();
                map.remove(k);
            }
         } else {
             deque.remove(key);
         }

        deque.addFirst(key);
        map.put(key, value);        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

Solution using DLL:
class LRUCache {
   class ListNode {
        int key;
        int value;
        ListNode next;
        ListNode prev;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
   }
   
   ListNode[] map;
   int capacity;
   ListNode head;
   ListNode tail;
   int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new ListNode[10_000+1];
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    public void addFirst(ListNode node) {
        if (null == node) {
            return;
        }

        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void remove(ListNode node) {
        if (null == node) {
            return;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public int removeLast() {
        if (head == tail.prev) {
            return -1;
        }

        int key = tail.prev.key;
        remove(tail.prev);
        return key;
    }

    public int get(int key) {
        ListNode node = map[key];
        if (null != node) {
            remove(node); // Remove
            addFirst(node); // Add first
            return node.value;
        }

        return -1;
    }
 
    
    public void put(int key, int value) {
         if (null == map[key]) {
            if (capacity == size) {
                int k = removeLast();
                if (-1 != k) {
                    map[k] = null;
                    size--;
                }
            }
         } else {
             remove(map[key]);
             map[key] = null;
             size--;
         }

        ListNode node = new ListNode(key, value);
        addFirst(node);
        map[key] = node;
        size++;      
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

Using LinkedHashMap:
######################
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > this.capacity;
    }
}
