package utils;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
public final class RandomListNodes {

  public static RandomListNode getList(int... vals) {
    if (vals == null || vals.length == 0) {
      return null;
    } else {
      RandomListNode head = new RandomListNode(vals[0]);
      RandomListNode prev = head;
      for (int i = 1; i < vals.length; i++) {
        prev.next = new RandomListNode(vals[1]);
        prev = prev.next;
      }
      return head;
    }
  }

  private RandomListNodes(){}
}
