package utils._138_Copy_List_with_Random_Pointer;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
public final class Nodes {

  public static Node getList(int... vals) {
    if (vals == null || vals.length == 0) {
      return null;
    } else {
      Node head = new Node(vals[0]);
      Node prev = head;
      for (int i = 1; i < vals.length; i++) {
        prev.next = new Node(vals[1]);
        prev = prev.next;
      }
      return head;
    }
  }

  private Nodes() {
  }
}
