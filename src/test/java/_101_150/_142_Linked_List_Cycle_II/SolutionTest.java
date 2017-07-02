package _101_150._142_Linked_List_Cycle_II;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNoCycle() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    assertEquals(null,solution.detectCycle(head));
  }
  @Test
  public void testSelfCycle() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    head.next.next.next.next.next = head.next.next;

    ListNode begin = Util.getListOfNodes(new int[]{3, 4, 5});
    assertEquals(begin.val, solution.detectCycle(head).val);
  }


}