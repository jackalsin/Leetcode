package _101_150._143_Reorder_List;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1});
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @Test
  public void test2() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 2});
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @Test
  public void test3() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 3, 2});
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @Test
  public void test4() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 4, 2, 3});
    solution.reorderList(head);
    assertEquals(expected, head);
  }

  @Test
  public void test5() throws Exception {
    ListNode head = ListNodes.getListOfNodes(new int[]{1, 2, 3, 4, 5});
    ListNode expected = ListNodes.getListOfNodes(new int[]{1, 5, 2, 4, 3});
    solution.reorderList(head);
    assertEquals(expected, head);
  }
}
