package _0301_0350._328_Odd_Even_Linked_List;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 3, 5, 2, 4});
    assertEquals(expected, solution.oddEvenList(head));
  }

  @Test
  public void testEmpty() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{});
    assertEquals(expected, solution.oddEvenList(head));
  }

  @Test
  public void testSingle() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    assertEquals(expected, solution.oddEvenList(head));
  }

  @Test
  public void test2Nodes() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2});
    assertEquals(expected, solution.oddEvenList(head));
  }

  @Test
  public void testNormalEven() throws Exception {
    final ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5, 6});
    final ListNode expected = ListNodes.getListOfNodes(new int[]{1, 3, 5, 2, 4, 6});
    assertEquals(expected, solution.oddEvenList(head));
  }

}
