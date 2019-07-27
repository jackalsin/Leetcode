package interviews.linkedin._706_Design_HashMap;

import java.util.ArrayList;
import java.util.List;

/**
 * 33 / 33 test cases passed.
 * Status: Accepted
 * Runtime: 110 ms
 */
public final class MyHashMapLinkedList implements Solution {
  private static final int MAX = 1_000_000, SIZE = 10_000;
  private final List<List<Node>> buckets = new ArrayList<>();

  {
    for (int i = 0; i < SIZE; ++i) {
      buckets.add(new ArrayList<>());
    }
  }

  public void put(int key, int value) {
    final int hash = key % SIZE;
    final List<Node> curList = buckets.get(hash);
    for (Node elem : curList) {
      if (elem.key == key) {
        elem.val = value;
        return;
      }
    }
    curList.add(new Node(key, value));
  }


  public int get(int key) {
    final int hash = key % SIZE;
    final List<Node> curList = buckets.get(hash);

    for (Node n : curList) {
      if (n.key == key) {
        return n.val;
      }
    }
    return -1;
  }


  public void remove(int key) {
    final int hash = key % SIZE;
    final List<Node> curList = buckets.get(hash);
    Node toRemove = null;
    int i = 0;
    for (; i < curList.size(); i++) {
      Node n = curList.get(i);
      if (n.key == key) {
        toRemove = n;
        break;
      }
    }
    if (toRemove != null) {
      curList.remove(i);
    }
  }

  private static final class Node {
    private int key, val;

    private Node(int key, int value) {
      this.key = key;
      this.val = value;
    }
  }
}
