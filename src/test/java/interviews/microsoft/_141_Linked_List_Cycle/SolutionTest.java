package interviews.microsoft._141_Linked_List_Cycle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testNoCycle0() {
    assertFalse(solution.hasCycle(null));
  }

  @Test
  void testNoCycle1() {
    ListNode head = ListNodes.getListOfNodes(new int[]{1});
    assertFalse(solution.hasCycle(head));
  }

  @Test
  void testNoCycle2() {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2});
    assertFalse(solution.hasCycle(head));
  }

  @Test
  void testCycle1() {
    ListNode head = new ListNode(1);
    head.next = head;
    assertTrue(solution.hasCycle(head));
  }

  @Test
  void testCycle2() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    assertTrue(solution.hasCycle(head));
  }

}