package _001_050._021_Merge_Two_Sorted_Lists;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;

import static org.junit.Assert.assertEquals;
import static utils.Util.getListOfNodes;

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
  public void testTwoEqualLengthList() throws Exception {
    final ListNode sampleAns = getListOfNodes(new int[] {1, 2, 3, 4, 5, 6});
    final ListNode left = getListOfNodes(new int[] {1, 3, 5});
    final ListNode right = getListOfNodes(new int[] {2, 4, 6});
    assertEquals(sampleAns, solution.mergeTwoLists(left, right));
  }

  @Test
  public void testWith1And3() throws Exception {
    final ListNode sampleAns = getListOfNodes(new int[] {0, 1, 2, 4});
    final ListNode left = getListOfNodes(new int[] {1});
    final ListNode right = getListOfNodes(new int[] {0, 2, 4});
    assertEquals(sampleAns, solution.mergeTwoLists(left, right));
  }

}