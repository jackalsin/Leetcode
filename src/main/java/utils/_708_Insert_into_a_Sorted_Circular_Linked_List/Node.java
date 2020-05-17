package utils._708_Insert_into_a_Sorted_Circular_Linked_List;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class Node {
  public int val;
  public Node next;

  public Node() {
  }

  public Node(int _val) {
    val = _val;
  }

  public Node(int _val, Node _next) {
    val = _val;
    next = _next;
  }
}
