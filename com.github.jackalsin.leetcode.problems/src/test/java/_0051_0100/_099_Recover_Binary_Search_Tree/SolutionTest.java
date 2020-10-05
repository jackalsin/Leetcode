package _0051_0100._099_Recover_Binary_Search_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/7/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void test2Elements() throws Exception {
    final TreeNode input = new TreeNode(0);
    input.left = new TreeNode(1);
    solution.recoverTree(input);
    final TreeNode expected = new TreeNode(1);
    expected.left = new TreeNode(0);

    assertEquals(expected, input);
  }

  @Test
  void test3Elements() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(new int[]{2, 3, 1});
    final TreeNode expected = TreeNodes.getTreeLevelOrder(new int[]{2, 1, 3});
    solution.recoverTree(input);
    assertEquals(expected, input);
  }


  @Test
  void test3ChildrenElements() throws Exception {
    final TreeNode input = TreeNodes.getTreeLevelOrder(new int[]{3, 1, 2});
    final TreeNode expected = TreeNodes.getTreeLevelOrder(new int[]{2, 1, 3});
    solution.recoverTree(input);
    assertEquals(expected, input);
  }

  @Test
  void test3ChildrenOneLineElements() throws Exception {
    final TreeNode input = new TreeNode(2);
    input.right = new TreeNode(3);
    input.right.left = new TreeNode(1);
    final TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(3);
    expected.right.left = new TreeNode(2);
    solution.recoverTree(input);
    assertEquals(expected, input);
  }

  @Test
  void testNullLeft() throws Exception {
    TreeNode input = new TreeNode(2);
    input.right = new TreeNode(1);
    TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(2);
    solution.recoverTree(input);
    assertEquals(expected, input);
  }
}
