package interviews.microsoft._024_Swap_Nodes_in_Pairs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOddList() {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 3, 5});
    final ListNode result = ListNodes.getListOfNodes(new int[]{3, 1, 5});
    assertEquals(result, solution.swapPairs(input));
  }

  @Test
  void testWithEvenList() {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4});
    final ListNode result = ListNodes.getListOfNodes(new int[]{2, 1, 4, 3});
    assertEquals(result, solution.swapPairs(input));
  }

}