package _051_100._086_Partition_List;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }
  @Test
  public void testOnlineCase() throws Exception {
    ListNode input = Util.getListOfNodes(new int[] {1, 4, 3, 2, 5, 2});
    ListNode expected = Util.getListOfNodes(new int[] {1, 2, 2, 4, 3, 5});
    assertEquals(expected, solution.partition(input, 3));
  }

  @Test
  public void testNull() throws Exception  {
    assertEquals(null, solution.partition(null, 0));
  }

  @Test
  public void testOneElement() throws Exception {
    ListNode input = Util.getListOfNodes(new int[] {1});
    ListNode expected = Util.getListOfNodes(new int[] {1});
    assertEquals(expected, solution.partition(input, 2));
  }

  @Test
  public void test3And1() throws Exception {
    ListNode input = Util.getListOfNodes(new int[] {3, 1});
    ListNode expected = Util.getListOfNodes(new int[] {1, 3});
    assertEquals(expected, solution.partition(input, 2));
  }

  @Test
  public void test2And1() throws Exception {
    ListNode input = Util.getListOfNodes(new int[] {2, 1});
    ListNode expected = Util.getListOfNodes(new int[] {2, 1});
    assertEquals(expected, solution.partition(input, 3));
  }
}