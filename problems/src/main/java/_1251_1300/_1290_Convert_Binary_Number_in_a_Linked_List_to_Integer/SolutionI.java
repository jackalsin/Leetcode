package _1251_1300._1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import definition.ListNode;

/**
 * @author jacka
 * @version 1.0 on 11/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int getDecimalValue(ListNode head) {
    int num = 0;
    while (head != null) {
      num = num * 2 + head.val;
      head = head.next;
    }
    return num;
  }
}
