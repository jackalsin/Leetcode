package _101_150._141_Linked_List_Cycle;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
  public void testNoCycle0() throws Exception {
    assertFalse(solution.hasCycle(null));
  }

  @Test
  public void testNoCycle1() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1});
    assertFalse(solution.hasCycle(head));
  }

  @Test
  public void testNoCycle2() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1, 2});
    assertFalse(solution.hasCycle(head));
  }

  @Test
  public void testCycle1() throws Exception {
    ListNode head = new ListNode(1);
    head.next = head;
    assertTrue(solution.hasCycle(head));
  }
  @Test
  public void testCycle2() throws Exception {
    ListNode head = new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = head;
    assertTrue(solution.hasCycle(head));
  }
}