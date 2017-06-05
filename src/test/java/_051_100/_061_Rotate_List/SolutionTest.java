package _051_100._061_Rotate_List;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/23/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith5And2() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode expected = Util.getListOfNodes(new int[]{4, 5, 1, 2, 3});
    assertEquals(expected, solution.rotateRight(head, 2));
  }

  @Test
  public void testWith5And7() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode expected = Util.getListOfNodes(new int[]{4, 5, 1, 2, 3});
    assertEquals(expected, solution.rotateRight(head, 7));
  }
  @Test
  public void testWith0And0() throws Exception {
    ListNode head = null;
    ListNode expected = null;
    assertEquals(expected, solution.rotateRight(head, 0));
  }

  @Test
  public void testWith1And1() throws Exception {
    ListNode head = Util.getListOfNodes(new int[]{1});
    ListNode expected = Util.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.rotateRight(head, 1));


  }

}