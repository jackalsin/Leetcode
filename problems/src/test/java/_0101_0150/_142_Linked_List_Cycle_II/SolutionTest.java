package _0101_0150._142_Linked_List_Cycle_II;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testNoCycle() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 7, 8});
    assertEquals(null, solution.detectCycle(head));
  }

  @Test
  void testSelfCycle() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    head.next.next.next.next.next = head.next.next;

    ListNode begin = ListNodes.getListOfNodes(new int[]{3, 4, 5});
    assertEquals(begin.val, solution.detectCycle(head).val);
  }

}
