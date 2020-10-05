package definition._430_Flatten_a_Multilevel_Doubly_Linked_List;

import java.util.Objects;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
public final class Node {
  public int val;
  public Node prev;
  public Node next;
  public Node child;

  @Deprecated
  public Node(int val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Node)) return false;
    Node node = (Node) o;
    return val == node.val &&
        (prev == node.prev || prev != null && node.prev != null && prev.val == node.prev.val) &&
        Objects.equals(next, node.next) &&
        Objects.equals(child, node.child);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, prev, next, child);
  }

  @Override
  public String toString() {
    return "Node{" +
        "val=" + val +
        ", prev=" + (prev == null ? "null" : prev.val) +
        ", next=" + next +
        ", child=" + child +
        '}';
  }
}
