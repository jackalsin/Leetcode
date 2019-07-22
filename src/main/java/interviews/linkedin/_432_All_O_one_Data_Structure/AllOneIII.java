package interviews.linkedin._432_All_O_one_Data_Structure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 7/21/2019
 */
public final class AllOneIII implements AllOne {
  private final Node head = new Node(Integer.MIN_VALUE),
      tail = new Node(Integer.MIN_VALUE);
  private final Map<String, Node> keyToNode = new HashMap<>();

  {
    head.next = tail;
    tail.prev = head;
  }

  public void inc(String key) {
    if (keyToNode.containsKey(key)) {
      final Node oldNode = keyToNode.get(key);
      if (oldNode.next.count != oldNode.count + 1) {
        final Node newNode = new Node(oldNode.count + 1);
        appendNode(oldNode, newNode);
      }
      final Node newNode = oldNode.next;
      newNode.keys.add(key);
      oldNode.keys.remove(key);
      if (oldNode.keys.isEmpty()) {
        remove(oldNode);
      }
      keyToNode.put(key, newNode);
    } else {
      if (head.next.count != 1) {
        appendNode(head, new Node(1));
      }
      final Node newNode = head.next;
      newNode.keys.add(key);
      keyToNode.put(key, newNode);
    }
  }

  private static void remove(final Node oldNode) {
    final Node prev = oldNode.prev, next = oldNode.next;
    prev.next = next;
    next.prev = prev;
  }

  private static void appendNode(final Node prev, final Node newNode) {
    final Node next = prev.next;
    prev.next = newNode;
    newNode.prev = prev;

    next.prev = newNode;
    newNode.next = next;
  }

  public void dec(String key) {

    if (!keyToNode.containsKey(key)) return;
    final Node oldNode = keyToNode.get(key);
    oldNode.keys.remove(key);

    if (oldNode.count == 1) {
      keyToNode.remove(key);
      if (oldNode.keys.isEmpty()) {
        remove(oldNode);
      }
      return;
    }
    if (oldNode.prev.count != oldNode.count - 1) {
      appendNode(oldNode.prev, new Node(oldNode.count - 1));
    }
    if (oldNode.keys.isEmpty()) {
      remove(oldNode);
    }
    final Node newNode = oldNode.prev;
    newNode.keys.add(key);
    keyToNode.put(key, newNode);
  }

  public String getMaxKey() {
    final Node prevNode = tail.prev;
    assert prevNode != null;
    return prevNode == head ? "" : prevNode.keys.iterator().next();
  }

  public String getMinKey() {
    final Node nextNode = head.next;
    assert nextNode != null;
    return nextNode == tail ? "" : nextNode.keys.iterator().next();
  }

  private static final class Node {
    private final Set<String> keys = new HashSet<>();
    private final int count;
    private Node prev, next;

    private Node(int count) {
      this.count = count;
    }
  }
}
