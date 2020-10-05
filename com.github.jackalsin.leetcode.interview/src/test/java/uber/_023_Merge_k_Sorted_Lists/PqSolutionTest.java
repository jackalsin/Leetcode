package uber._023_Merge_k_Sorted_Lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
class PqSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new PqSolution();
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
}
