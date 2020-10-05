package _0001_0050._024_Swap_Nodes_in_Pairs;

import definition.ListNode;
import definition.ListNodes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/23.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOddList() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 3, 5});
    final ListNode result = ListNodes.getListOfNodes(new int[]{3, 1, 5});
    assertEquals(result, solution.swapPairs(input));
  }

  @Test
  public void testWithEvenList() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4});
    final ListNode result = ListNodes.getListOfNodes(new int[]{2, 1, 4, 3});
    assertEquals(result, solution.swapPairs(input));
  }
}
