package utils;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/4/2017.
 */
public final class ListNodes {

  /**
   * Return the head of a list of {@code ListNode}.
   *
   * @param values an array of integer values to be assigned to the list.
   * @return the head of the integer list of ListNode
   * @throws NullPointerException if values is null
   */
  public static ListNode getListOfNodes(int... values) {
    if (values == null) {
      throw new NullPointerException();
    } else {
      ListNode dummy = new ListNode(Integer.MIN_VALUE);
      ListNode cur = dummy;
      for (int val : values) {
        cur.next = new ListNode(val);
        cur = cur.next;
      }
      return dummy.next;
    }
  }

  private ListNodes() {
  }
}
