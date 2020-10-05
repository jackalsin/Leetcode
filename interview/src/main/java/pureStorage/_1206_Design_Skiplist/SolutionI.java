package pureStorage._1206_Design_Skiplist;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 10/8/2019
 */
public final class SolutionI implements Skiplist {
  private final Node head = new Node(Integer.MIN_VALUE);

  // Sentinel
  //          \
  // level 3: -Inf ----------------------------> 4
  // level 2: -Inf ------------> 2 ------------> 4
  // level 1: -Inf ----> 1 ----> 2 ------------> 4
  // level 0: -Inf ----> 1 ----> 2 ----> 3 ----> 4 : this level is the most concrete level
  private static final double DEFAULT_PROB = 0.5;
  private final Random rand = new Random();

  public boolean search(int target) {
    return searchHelper(target).val == target;
  }

  public void add(int target) {
    final Node smallOrEqual = searchHelper(target);
    final Node toInsert = new Node(target);
    append(smallOrEqual, toInsert);
    populate(toInsert);
  }

  private void populate(Node toInsert) {
    Node prev = toInsert.left, cur = toInsert;
    while (flipCoin()) {
      while (prev.left != null && prev.up == null) {
        prev = prev.left;
      }
      // add new sentinel
      if (prev.up == null) {
        final Node newSentinel = new Node(Integer.MIN_VALUE);
        prev.up = newSentinel;
        newSentinel.down = prev;
      }

      final Node newNode = new Node(toInsert.val);
      toInsert.up = newNode;
      newNode.down = toInsert;

      prev = prev.up;
      toInsert = toInsert.up;
      append(prev, toInsert);
    }
  }

  private static void append(final Node prev, final Node node) {
    final Node next = prev.right;
    prev.right = node;
    node.left = prev;
    if (next != null) {
      next.left = node;
      node.right = next;
    }
  }

  public boolean erase(int num) {
    Node cur = searchHelper(num);
    if (cur.val != num) {
      return false;
    }
    while (cur != null) {
      final Node left = cur.left, right = cur.right;
      left.right = right;
      if (right != null) {
        right.left = left;
      }
      cur = cur.up;
    }
    return true;
  }

  private Node searchHelper(int target) {
    Node cur = getSentinel();
    while (cur != null) {
      if (cur.right == null || cur.right.val > target) {
        if (cur.down == null) break;
        cur = cur.down;
      } else {
        cur = cur.right;
      }
    }

    return cur;
  }

  private boolean flipCoin() {
    return rand.nextDouble() < DEFAULT_PROB;
  }

  private Node getSentinel() {
    Node cur = head;
    while (cur.up != null) {
      cur = cur.up;
    }
    return cur;
  }

  private static final class Node {
    private Node left, right, up, down;
    private final int val;

    private Node(int val) {
      this.val = val;
    }
  }

  @Override
  public String toString() {
    Node node = head;
    final StringBuilder sb = new StringBuilder();
    while (node != null) {
      Node itr = node;
      while (itr != null) {
        sb.append(itr.val).append(",");
        itr = itr.up;
      }
      sb.append("\n");
      node = node.right;
    }
    return sb.toString();
  }

}
