package _0051_0100._092_Reverse_Linked_List_II;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmptyBias() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    assertEquals(input, solution.reverseBetween(input, 3, 3));
  }


  @Test
  public void testFull() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{5, 4, 3, 2, 1});
    assertEquals(expected, solution.reverseBetween(input, 1, 5));
  }

  @Test
  public void testOnline() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 4, 3, 2, 5});
    assertEquals(expected, solution.reverseBetween(input, 2, 4));
  }


}
