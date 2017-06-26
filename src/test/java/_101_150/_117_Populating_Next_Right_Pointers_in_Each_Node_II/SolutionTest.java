package _101_150._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import org.junit.Before;
import org.junit.Test;

import utils.TreeLinkNode;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFullBalancedTree() throws Exception {
    TreeLinkNode expected = new TreeLinkNode(1);
    expected.left = new TreeLinkNode(2);
    expected.right = new TreeLinkNode(3);
    expected.left.next = expected.right;

    expected.left.left = new TreeLinkNode(4);
    expected.left.right = new TreeLinkNode(5);
    expected.right.left = new TreeLinkNode(6);
    expected.right.right = new TreeLinkNode(7);

    expected.left.left.next = expected.left.right;
    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);

    root.left.left = new TreeLinkNode(4);
    root.left.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

  @Test
  public void testNullInMid() throws Exception {
    TreeLinkNode expected = new TreeLinkNode(1);
    expected.left = new TreeLinkNode(2);
    expected.right = new TreeLinkNode(3);
    expected.left.next = expected.right;

    expected.left.left = new TreeLinkNode(4);
    expected.right.left = new TreeLinkNode(6);
    expected.right.right = new TreeLinkNode(7);

    expected.left.left.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);

    root.left.left = new TreeLinkNode(4);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

  @Test
  public void testNullInHead() throws Exception {
    TreeLinkNode expected = new TreeLinkNode(1);
    expected.left = new TreeLinkNode(2);
    expected.right = new TreeLinkNode(3);
    expected.left.next = expected.right;

    expected.left.right = new TreeLinkNode(5);
    expected.right.left = new TreeLinkNode(6);
    expected.right.right = new TreeLinkNode(7);

    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);

    root.left.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    solution.connect(root);

    assertEquals(expected, root);
  }

}