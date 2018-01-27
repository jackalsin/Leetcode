package interviews.google._460_LFU_Cache;

import java.util.HashMap;
import java.util.HashSet;
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
      // remove a key
      countNode.keySet.remove(key);

      // next is the right place
      if (countNode.next.count == countNode.count + 1) {
        countNode.next.keySet.add(key);
        keyToCounts.put(key, countNode.next);
      } else { // not the right place
        final CountNode toAdd = new CountNode(countNode.count + 1);
        addToLink(countNode, toAdd, countNode.next);
      }

      if (countNode.keySet.isEmpty()) {
        removeCountNode(countNode);
      }
      return res;
    } else {
      return INVALID;
    }
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

  /**
   * put also counts as use
   *
   * @param key
   * @param value
   */
  public void put(int key, int value) {

  }


  private static final class CountNode {
    private final int count;
    private final Set<Integer> keySet = new HashSet<>();
    private CountNode prev, next;

    public CountNode(int count) {
      this.count = count;
    }
  }

}
