package uber._024_Swap_Nodes_in_Pairs;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/12/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithOddList() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[] {1, 3, 5});
    final ListNode result = ListNodes.getListOfNodes(new int[] {3, 1, 5});
    assertEquals(result, solution.swapPairs(input));
  }

  @Test
  void testWithEvenList() throws Exception {
    final ListNode input;
    input = ListNodes.getListOfNodes(new int[] {1, 2, 3, 4});
    final ListNode result = ListNodes.getListOfNodes(new int[] {2, 1, 4, 3});
    assertEquals(result, solution.swapPairs(input));
  }

}
