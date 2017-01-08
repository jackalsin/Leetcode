package utils;

/**
 * This class defines a node for a singly-linked list.
 *
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public final class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListNode)) {
      return false;
    }

    ListNode listNode = (ListNode) o;

    if (val != listNode.val) {
      return false;
    }
    return next != null ? next.equals(listNode.next) : listNode.next == null;
  }

  @Override
  public int hashCode() {
    int result = val;
    result = 31 * result + (next != null ? next.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ListNode{" +
        "val=" + val +
        ", next=" + next +
        '}';
  }
}
