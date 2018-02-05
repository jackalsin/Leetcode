package _401_450._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/4/2018.
 */
public class AllOne {
  private final CountNode head, tail;
  private final Map<String, CountNode> keyToCountNode = new HashMap<>();

  /**
   * Initialize your data structure here.
   */
  public AllOne() {
    head = new CountNode(0);
    tail = new CountNode(-1);
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    keyToCountNode.putIfAbsent(key, head);
    increaseKey(key);

//    displayNode();
  }

  private void increaseKey(String key) {
    final CountNode oldCountNode = keyToCountNode.get(key);

    if (oldCountNode.next.count != oldCountNode.count + 1) {
      insertCountNode(oldCountNode, new CountNode(oldCountNode.count + 1), oldCountNode.next);
    }
    final CountNode curCountNode = oldCountNode.next;

    oldCountNode.keys.remove(key);
    if (oldCountNode != head && oldCountNode != tail && oldCountNode.keys.isEmpty()) {
      removeCountNode(oldCountNode);
    }

    curCountNode.keys.add(key);
    keyToCountNode.put(key, curCountNode);
  }

  private void insertCountNode(CountNode prevCountNode, CountNode curNode, CountNode
      nextCountNode) {
    prevCountNode.next = curNode;
    curNode.prev = prevCountNode;

    curNode.next = nextCountNode;
    nextCountNode.prev = curNode;
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    if (keyToCountNode.containsKey(key)) {
      final CountNode oldCountNode = keyToCountNode.get(key);
      if (oldCountNode.prev.count != oldCountNode.count - 1) {
        insertCountNode(oldCountNode.prev, new CountNode(oldCountNode.count - 1), oldCountNode);
      }
      oldCountNode.keys.remove(key);
      keyToCountNode.remove(key);
      final CountNode curCountNode = oldCountNode.prev;

      if (oldCountNode.keys.isEmpty()) {
        removeCountNode(oldCountNode);
      }

      if (oldCountNode.count != 1) {
        keyToCountNode.put(key, curCountNode);
        curCountNode.keys.add(key);
      }
    }
//    displayNode();
  }

  private void removeCountNode(CountNode oldCountNode) {
    final CountNode prevCountNode = oldCountNode.prev, nextCountNode = oldCountNode.next;
    prevCountNode.next = nextCountNode;
    nextCountNode.prev = prevCountNode;
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    final CountNode maxNode = tail.prev;
    if (maxNode == head) {
      return "";
    }
    return maxNode.keys.iterator().next();
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    final CountNode minNode = head.next;
    if (minNode == tail) {
      return "";
    }
    return minNode.keys.iterator().next();
  }

  private static final class CountNode {
    private final int count;
    private final Set<String> keys = new HashSet<>();
    private CountNode prev, next;

    private CountNode(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "CountNode{" +
          "count=" + count +
          ", keys=" + keys +
          '}';
    }
  }

  private void displayNode() {
    CountNode curNode = head;
    while (curNode != null) {
      System.out.print(curNode + "\t");
      curNode = curNode.next;
    }
    System.out.println();
  }
}
