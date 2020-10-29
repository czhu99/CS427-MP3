package BlackBox;

import BlackBox.LruCache;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl implements LruCache {

    private class LinkedNode{
        public int key, value;
        public LinkedNode prev,next;
        public LinkedNode(int key, int value){
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }
    public Map<Integer, LinkedNode> map;
    public LinkedNode head;
    public LinkedNode tail;
    public int capacity;
    public LruCacheImpl(int capacity) {
        map = new HashMap<>();
        head = new LinkedNode(0,0);
        tail = new LinkedNode(0,0);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    private void addNode(LinkedNode node){
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }

    private void removeNode(LinkedNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    public int get(int key) {
        LinkedNode node = map.get(key);
        if(node == null){
            return -1;
        }
        else{
            removeNode(node);
            addNode(node);
            return node.value;
        }
    }

    public void put(int key, int value) {
        LinkedNode oldNode = map.get(key);
        LinkedNode newNode = new LinkedNode(key,value);
        if(oldNode == null){
            if(map.size() == capacity){
                map.remove(head.next.key);
                removeNode(head.next);
            }
        }else{
            removeNode(oldNode);
        }
        map.put(key,newNode);
        addNode(newNode);
    }

}
