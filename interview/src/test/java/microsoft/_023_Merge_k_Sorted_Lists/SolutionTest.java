package microsoft._023_Merge_k_Sorted_Lists;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithAllNull() {
    final ListNode[] input = new ListNode[]{null, null};
    assertEquals(null, solution.mergeKLists(input));
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

}