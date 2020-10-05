package definition._430_Flatten_a_Multilevel_Doubly_Linked_List;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
public final class Nodes {
  private Nodes() {
  }

  public static Node getNodes(final Node... nodes) {
    if (nodes == null) {
      return null;
    }
    final Node head = nodes[0];
    Node prev = head;
    for (int i = 1; i < nodes.length; ++i) {
      prev.next = nodes[i];
      nodes[i].prev = prev;
      prev = prev.next;
    }
    return head;
  }

  public static Node getNodes(final int... vals) {
    if (vals == null) {
      return null;
    }
    final Node head = new Node(vals[0]);
    Node prev = head;
    for (int i = 1; i < vals.length; ++i) {
      final Node node = new Node(vals[i]);
      prev.next = node;
      node.prev = prev;
      prev = prev.next;
    }
    return head;
  }
}
