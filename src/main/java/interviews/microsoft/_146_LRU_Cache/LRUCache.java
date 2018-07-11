package interviews.microsoft._146_LRU_Cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
  private final Node head = new Node(0), tail = new Node(Integer.MAX_VALUE);
  private final int capacity;

  private final Map<Integer, Node> keyToNode = new HashMap<>();
  private final Map<Integer, Integer> keyToVal = new HashMap<>();


  public LRUCache(int capacity) {
    this.capacity = capacity;
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (capacity == 0 || !keyToVal.containsKey(key)) {
      return -1;
    }

    final Node curNode = keyToNode.get(key);

    removeFromDoubleLinkedList(curNode);
    append(head, curNode);

    return keyToVal.get(key);
  }

  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    if (keyToNode.containsKey(key)) {
      final Node curNode = keyToNode.get(key);
      keyToVal.put(key, value);
      removeFromDoubleLinkedList(curNode);
      append(head, curNode);
    } else {

      if (capacity == keyToVal.size()) {
        final Node toRemove = tail.prev;
        // remove tail prev
        keyToNode.remove(toRemove.key);
        keyToVal.remove(toRemove.key);
        removeFromDoubleLinkedList(toRemove);
      }

      final Node curNode = new Node(key);
      keyToNode.put(key, curNode);
      keyToVal.put(key, value);

      append(head, curNode);

    }
  }

  private void append(Node prev, Node curNode) {
    final Node next = prev.next;
    prev.next = curNode;
    curNode.prev = prev;

    curNode.next = next;
    next.prev = curNode;
  }

  private void removeFromDoubleLinkedList(Node curNode) {
    final Node prev = curNode.prev, next = curNode.next;

    prev.next = next;
    next.prev = prev;

    curNode.prev = null;
    curNode.next = null;
  }

  private static final class Node {
    private final int key;
    private Node prev, next;

    private Node(int val) {
      this.key = val;
    }
  }
}
