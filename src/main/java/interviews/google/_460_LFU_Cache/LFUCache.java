package interviews.google._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class LFUCache {
  private static final int INVALID = -1;
  private final int capacity;
  private final Map<Integer, Integer> keyToValue = new HashMap<>();
  private final Map<Integer, CountNode> keyToCounts = new HashMap<>();

  private final CountNode head, tail;

  public LFUCache(int capacity) {
    this.capacity = capacity;

    head = new CountNode(INVALID);
    tail = new CountNode(INVALID);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      int res = keyToValue.get(key);
      final CountNode countNode = keyToCounts.get(key);
      removeKeyFromCountNodeAndAddToNext(countNode, key);
      return res;
    } else {
      return INVALID;
    }
  }

  /**
   * put also counts as use
   */
  public void put(int key, int value) {
    if (capacity == 0) {
      return;
    }
    keyToValue.put(key, value);
    if (keyToCounts.containsKey(key)) {
      final CountNode countNode = keyToCounts.get(key);
      removeKeyFromCountNodeAndAddToNext(countNode, key);
    } else {
      if (keyToCounts.size() == capacity) {
        final int toRemoveKey = head.next.keySet.iterator().next();
        keyToValue.remove(toRemoveKey);
        removeKeyFromCountNode(head.next, toRemoveKey);
      }
      if (head.next.count != 1) {
        final CountNode countNode = new CountNode(1);
        addToLink(head, countNode, head.next);
      }
      final CountNode countNode = head.next;
      countNode.keySet.add(key);
      keyToCounts.put(key, countNode);
    }
  }

  private void removeKeyFromCountNode(final CountNode countNode, int key) {
    countNode.keySet.remove(key);
    if (countNode.keySet.isEmpty()) {
      removeCountNode(countNode);
    }
    keyToCounts.remove(key);
  }

  private void removeKeyFromCountNodeAndAddToNext(CountNode countNode, int key) {
    // remove a key
    countNode.keySet.remove(key);
    // next is the right place
    if (countNode.next.count == countNode.count + 1) {
      countNode.next.keySet.add(key);
      keyToCounts.put(key, countNode.next);
    } else { // not the right place
      final CountNode toAdd = new CountNode(countNode.count + 1);
      toAdd.keySet.add(key);
      addToLink(countNode, toAdd, countNode.next);
    }

    if (countNode.keySet.isEmpty()) {
      removeCountNode(countNode);
    }
    keyToCounts.put(key, countNode.next);
  }


  private void removeCountNode(CountNode countNode) {
    final CountNode prev = countNode.prev, next = countNode.next;
    prev.next = next;
    next.prev = prev;
  }

  private void addToLink(CountNode prev, CountNode toAdd, CountNode next) {
    prev.next = toAdd;
    toAdd.prev = prev;

    toAdd.next = next;
    next.prev = toAdd;
  }

  public void displayHead() {
    System.out.println(keyToCounts);
    System.out.println(keyToValue);
    CountNode cur = head;
    while (cur != null) {
      System.out.println(cur);
      cur = cur.next;
    }

    System.out.println();
  }
  private static final class CountNode {
    private final int count;
    private final Set<Integer> keySet = new LinkedHashSet<>();
    private CountNode prev, next;

    public CountNode(int count) {
      this.count = count;
    }

    @Override
    public String toString() {
      return "CountNode{" +
          "count=" + count +
          ", keySet=" + keySet +
          ", prev=" + (prev == null ? null : prev.count) +
          ", next=" + (next == null ? null : next.count) +
          '}';
    }
  }
}
