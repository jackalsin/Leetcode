package _451_500._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 7/7/2017.
 */
public class LFUCache {
  private Node head, tail;
  private int capacity = 0;
  private Map<Integer, Integer> keyToValues = new HashMap<>();
  private Map<Integer, Node> keyToCountNodes = new HashMap<>();

  public LFUCache(int capacity) {
    this.capacity = capacity;
    head = new Node(0);
    tail = new Node(Integer.MAX_VALUE);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (keyToValues.containsKey(key)) {
      increaseCount(key);
      return keyToValues.get(key);
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    if (capacity == 0) return;
    if (keyToValues.containsKey(key)) {
      keyToValues.put(key, value);
    } else {
      if (keyToValues.size() < capacity) {
        keyToValues.put(key, value);
      } else {
        removeOldest();
        keyToValues.put(key, value);
      }
      addToHead(key);
    }
    increaseCount(key);
  }

  private void removeOldest() {
    Node toRemove = head.next;

    int oldestKey = 0;
    for (int key : toRemove.keys) {
      oldestKey = key;
      break;
    }
    toRemove.keys.remove(oldestKey);
    if(toRemove.keys.size() == 0) {
      remove(toRemove);
    }
    keyToCountNodes.remove(oldestKey);
    keyToValues.remove(oldestKey);
  }

  private void addToHead(int key) {
    if (head.next.count == 0) {
      head.next.keys.add(key);
    } else {
      Node toAdd = new Node(0);
      toAdd.keys.add(key);
      Node next = head.next;

      head.next = toAdd;
      toAdd.prev = head;

      next.prev = toAdd;
      toAdd.next = next;
    }
    keyToCountNodes.put(key, head.next);
  }

  private void increaseCount(int key) {
    final Node node = keyToCountNodes.get(key);
    node.keys.remove(key);

    if (node.next.count == node.count + 1) {
      node.next.keys.add(key);
    } else {
      // insert to @param node and node.next
      Node toInsert = new Node(node.count + 1);
      Node after = node.next;
      toInsert.keys.add(key);
      node.next = toInsert;
      toInsert.prev = node;

      toInsert.next = after;
      after.prev = toInsert;
    }
    keyToCountNodes.put(key, node.next);
    if (node.keys.size() == 0) {
      remove(node);
    }
  }

  private void remove(Node node) {
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;
    node.prev = null;
    node.next = null;
  }


  /**
   * The key that has the same counts stored in the same <@class>Node</@class>
   */
  private static final class Node {
    int count = 0;
    LinkedHashSet<Integer> keys;
    Node prev, next;

    Node(int count) {
      this.count = count;
      keys = new LinkedHashSet<>();
      prev = next = null;
    }

    @Override
    public String toString() {
      return "Node{" +
          "count=" + count +
          ", keys=" + keys +
          ", next=" + next +
          '}';
    }
  }

}
