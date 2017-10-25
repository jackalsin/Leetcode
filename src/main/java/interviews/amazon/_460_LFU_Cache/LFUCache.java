package interviews.amazon._460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public final class LFUCache {
  private final Node dummy;
  private final Map<Integer, Node> keyToNode;
  private final Map<Integer, Integer> keyToValue;
  private final int capacity;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    dummy = new Node(-1);
    keyToNode = new HashMap<>();
    keyToValue = new HashMap<>();
  }

  public int get(int key) {
    if (keyToValue.containsKey(key)) {
      increaseCount(key);
      return keyToValue.get(key);
    }
    return -1;
  }

  private void increaseCount(int key) {

  }

  public void put(int key, int value) {

  }

  private static final class Node {
    private final Set<Integer> keySet;
    private final int count;
    private Node prev = null, next = null;

    public Node(int counts) {
      keySet = new LinkedHashSet<>();
      this.count = counts;
    }

  }

}
