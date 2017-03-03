package _001_050._023_Merge_k_Sorted_Lists;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithAllNull() throws Exception {
    final ListNode[] input = new ListNode[] {null, null};
    assertEquals(null, solution.mergeKLists(input));
  }

  @Test
  public void testWithEqualLength() throws Exception {
    final ListNode node1 = Util.getListOfNodes(new int[] {1, 5, 7});
    final ListNode node2 = Util.getListOfNodes(new int[] {2, 4, 6});
    final ListNode node3 = Util.getListOfNodes(new int[] {3, 6, 8});
    final ListNode[] input = new ListNode[] {node1, node2, node3};
    final ListNode result = Util.getListOfNodes(new int[] {1, 2, 3, 4, 5, 6, 6, 7, 8});
    assertEquals(result, solution.mergeKLists(input));
  }
}