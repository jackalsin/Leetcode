package interviews.uber._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class AllOne {
  private static final int INVALID = -1;
  private final CountNode head = new CountNode(INVALID), tail = new CountNode(INVALID);
  private final Map<String, CountNode> keyToCountNode = new HashMap<>();

  /**
   * Initialize your data structure here.
   */
  public AllOne() {
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    if (keyToCountNode.containsKey(key)) {
      final CountNode curNode = keyToCountNode.get(key);
      if (curNode.next.val != curNode.val + 1) { // if the next count is not just larger than one, insert one.
        final CountNode newNode = new CountNode(curNode.val + 1);
        insertAfter(curNode, newNode);
      }
      // remove from the old countNode
      curNode.keys.remove(key);
      if (curNode.keys.isEmpty()) {
        remove(curNode);
      }

      // add key in the new node
      final CountNode newNode = curNode.next;
      newNode.keys.add(key);

      //update keyNode map
      keyToCountNode.put(key, newNode);
    } else {
      if (head.next.val != 1) {
        final CountNode count1 = new CountNode(1);
        insertAfter(head, count1);
      }
      keyToCountNode.put(key, head.next);
      head.next.keys.add(key);
    }
  }

  private void remove(CountNode curNode) {
    final CountNode prev = curNode.prev, next = curNode.next;
    prev.next = next;
    next.prev = prev;
  }

  private void insertAfter(final CountNode prev, final CountNode cur) {
    final CountNode next = prev.next;
    prev.next = cur;
    cur.prev = prev;

    cur.next = next;
    next.prev = cur;
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    if (keyToCountNode.containsKey(key)) {
      final CountNode oldNode = keyToCountNode.get(key);
      if (oldNode.val != oldNode.prev.val + 1) {
        final CountNode newNode = new CountNode(oldNode.val - 1);
        insertAfter(oldNode.prev, newNode);
      }
      final CountNode newNode = oldNode.prev;
      // update key set
      oldNode.keys.remove(key);
      if (oldNode.keys.isEmpty()) {
        remove(oldNode);
      }
      newNode.keys.add(key);

      // update keyNodeMap
      keyToCountNode.put(key, newNode);

      if (newNode.val == 0) {
        remove(newNode);
        keyToCountNode.remove(key);
      }
    }
  }

  /**
   * Returns one of the keys with maximal value.
   * Otherwise, return an empty String
   */
  public String getMaxKey() {
    if (tail.prev == head) {
      return "";
    }
    return tail.prev.keys.iterator().next();
  }

  /**
   * Returns one of the keys with Minimal value.
   * Otherwise, return an empty String
   */
  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    return head.next.keys.iterator().next();
  }

  private static final class CountNode {
    private final int val;
    private final Set<String> keys = new HashSet<>();
    private CountNode prev, next;

    CountNode(int val) {
      this.val = val;
    }
  }
}
