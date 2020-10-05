package _0701_0750._707_Design_Linked_List;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class MyLinkedListI implements MyLinkedList {
  private final Node head = new Node(-1);

  public int get(int index) {
    Node cur = getNode(index);
    return cur == null ? -1 : cur.val;
  }

  public void addAtHead(int val) {
    append(head, new Node(val));
  }

  private static void append(final Node prev, final Node node) {
    final Node next = prev.next;
    prev.next = node;
    node.next = next;
  }

  private Node getNode(int index) {
    Node cur = head;
    for (int i = 0; i <= index; ++i) {
      cur = cur.next;
      if (cur == null) return null;
    }
    return cur;
  }

  public void addAtTail(int val) {
    Node cur = head;
    while (cur.next != null) {
      cur = cur.next;
    }
    cur.next = new Node(val);
  }

  public void addAtIndex(int index, int val) {
    final Node prev = getNode(index - 1);
    if (prev == null) return;
    append(prev, new Node(val));
  }

  public void deleteAtIndex(int index) {
    final Node prev = getNode(index - 1);
    if (prev == null || prev.next == null) return;
    prev.next = prev.next.next;
  }

  private static final class Node {
    private final int val;
    private Node next;

    private Node(int val) {
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node{" +
          "val=" + val +
          ", next=" + next +
          '}';
    }
  }
}
