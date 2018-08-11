package interviews.microsoft.noodleEssence._023_Merge_k_Sorted_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithAllNull() {
    final ListNode[] input = new ListNode[]{null, null};
    assertNull(solution.mergeKLists(input));
  }

  @Test
  void testWithEmpty() {
    final ListNode[] input = new ListNode[]{};
    assertNull(solution.mergeKLists(input));
  }

  @Test
  void testWithEqualLength() {
    final ListNode node1 = ListNodes.getListOfNodes(new int[]{1, 5, 7});
    final ListNode node2 = ListNodes.getListOfNodes(new int[]{2, 4, 6});
    final ListNode node3 = ListNodes.getListOfNodes(new int[]{3, 6, 8});
    final ListNode[] input = new ListNode[]{node1, node2, node3};
    final ListNode result = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8});
    assertEquals(result, solution.mergeKLists(input));
  }

  @Test
  void testWithFailedCase() {
    final ListNode node1 = ListNodes.getListOfNodes(new int[]{-6, -3, -1, 1, 2, 2, 2});
    final ListNode node2 = ListNodes.getListOfNodes(new int[]{-10, -8, -6, -2, 4});
    final ListNode node3 = ListNodes.getListOfNodes(new int[]{-2});
    final ListNode node4 = ListNodes.getListOfNodes(new int[]{-8, -4, -3, -3, -2, -1, 1, 2, 3});
    final ListNode node5 = ListNodes.getListOfNodes(new int[]{-8, -6, -5, -4, -2, -2, 2, 4});
    final ListNode[] input = new ListNode[]{node1, node2, node3, node4, node5};
    final ListNode expected = ListNodes.getListOfNodes(new int[]{
        -10, -8, -8, -8, -6, -6, -6, -5, -4, -4, -3, -3, -3, -2, -2, -2, -2, -2, -1, -1, 1, 1, 2, 2, 2, 2, 2, 3, 4, 4});
    assertEquals(expected, solution.mergeKLists(input));
  }
}