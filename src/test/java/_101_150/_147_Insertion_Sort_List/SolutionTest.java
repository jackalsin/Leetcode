package _101_150._147_Insertion_Sort_List;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/9/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    solution.insertionSortList(null);
  }

  @Test
  public void testOneElement() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[] {2});
    final ListNode expected = ListNodes.getListOfNodes(new int[] {2});
    assertEquals(expected, solution.insertionSortList(input));
  }

  @Test
  public void test5Element() throws Exception {
    final ListNode input = ListNodes.getListOfNodes(new int[]{4, 3, 1, 2, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[] {1, 2, 3, 4, 5});
    assertEquals(expected, solution.insertionSortList(input));
  }

}
