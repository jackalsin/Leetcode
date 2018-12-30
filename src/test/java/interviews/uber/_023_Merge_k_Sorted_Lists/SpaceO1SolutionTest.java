package interviews.uber._023_Merge_k_Sorted_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SpaceO1SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SpaceO1Solution();
  }

  @Test
  void testWithAllNull() throws Exception {
    final ListNode[] input = new ListNode[]{null, null};
    assertNull(solution.mergeKLists(input));
  }

  @Test
  void testWithEqualLength() throws Exception {
    final ListNode node1 = ListNodes.getListOfNodes(new int[]{1, 5, 7});
    final ListNode node2 = ListNodes.getListOfNodes(new int[]{2, 4, 6});
    final ListNode node3 = ListNodes.getListOfNodes(new int[]{3, 6, 8});
    final ListNode[] input = new ListNode[]{node1, node2, node3};
    final ListNode result = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8});
    assertEquals(result, solution.mergeKLists(input));
  }

  @Test
  void testFailedCase1() throws Exception {
    final ListNode node1 = ListNodes.getListOfNodes(new int[]{1, 4, 5});
    final ListNode node2 = ListNodes.getListOfNodes(new int[]{1, 3, 4});
    final ListNode node3 = ListNodes.getListOfNodes(new int[]{2, 6});
    final ListNode[] input = new ListNode[]{node1, node2, node3};
    final ListNode result = ListNodes.getListOfNodes(new int[]{1, 1, 2, 3, 4, 4, 5, 6});
    assertEquals(result, solution.mergeKLists(input));
  }
}