package _001_100._025_Reverse_Nodes_in_k_Group;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.Util;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/24.
 */
public class SolutionTest {
  private Solution solution;

  private final int[] ARRAY = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }


  @Test
  public void testWithK1() throws Exception {
    final ListNode rtnHead = Util.getListOfNodes(ARRAY);
    assertEquals(Util.getListOfNodes(ARRAY), solution.reverseKGroup(rtnHead, 1));
  }

  @Test
  public void testWithK3() throws Exception {
    final ListNode stdHead = Util.getListOfNodes(new int[] {3, 2, 1, 6, 5, 4, 9, 8, 7});
    final ListNode rtnHead = Util.getListOfNodes(ARRAY);
    assertEquals(stdHead, solution.reverseKGroup(rtnHead, 3));
  }
}