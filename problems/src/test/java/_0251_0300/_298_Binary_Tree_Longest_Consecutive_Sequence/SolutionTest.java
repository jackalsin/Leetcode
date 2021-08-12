package _0251_0300._298_Binary_Tree_Longest_Consecutive_Sequence;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/10/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final TreeNode root = new TreeNode(1);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);
    assertEquals(3, solution.longestConsecutive(root));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final TreeNode root = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.left = new TreeNode(1);
    assertEquals(2, solution.longestConsecutive(root));
  }

  @Test
  public void testNull() throws Exception {

  }

}
