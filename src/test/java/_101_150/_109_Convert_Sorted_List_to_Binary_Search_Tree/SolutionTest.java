package _101_150._109_Convert_Sorted_List_to_Binary_Search_Tree;

import org.junit.Before;
import org.junit.Test;

import utils.ListNode;
import utils.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/19/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test0Element() throws Exception {
    assertEquals(null, solution.sortedListToBST(null));
  }

  @Test
  public void test1Element() throws Exception {
    assertEquals(new TreeNode(1), solution.sortedListToBST(new ListNode(1)));
  }

  @Test
  public void test2Element() throws Exception {
    ListNode inputHead = new ListNode(1);
      inputHead.next = new ListNode(2);
    TreeNode expected = new TreeNode(2);
      expected.left = new TreeNode(1);
    assertEquals(expected, solution.sortedListToBST(inputHead));
  }

  @Test
  public void test3Element() throws Exception {
    ListNode inputHead = new ListNode(1);
      inputHead.next = new ListNode(2);
        inputHead.next.next = new ListNode(3);
    TreeNode expected = new TreeNode(2);
    expected.left = new TreeNode(1);
    expected.right = new TreeNode(3);
    assertEquals(expected, solution.sortedListToBST(inputHead));
  }

}