package _051_100._082_Remove_Duplicates_from_Sorted_List_II;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.ListNodes;
import utils.Util;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNoDup() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4, 5};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(input);
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @Test
  public void testLeadingDup() throws Exception {
    final int[] input = new int[] {1, 1, 1, 2, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(new int[] {2, 3});
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @Test
  public void testTailingDup() throws Exception {
    final int[] input = new int[] {1, 2, 3, 3, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode expected = ListNodes.getListOfNodes(new int[] {1, 2});
    assertEquals(expected, solution.deleteDuplicates(head));
  }

  @Test
  public void testContiousDup () throws Exception {
    final int[] input = new int[] {2, 2, 3, 3};
    final ListNode head = ListNodes.getListOfNodes(input);
    final ListNode actual = solution.deleteDuplicates(head);
    assertEquals(null, solution.deleteDuplicates(head));
  }
}
