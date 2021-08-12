package _0101_0150._144_Binary_Tree_Preorder_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/8/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNull() throws Exception {
    assertEquals(new ArrayList<>(), solution.preorderTraversal(null));
  }

  @Test
  public void testOneNode() throws Exception {
    assertEquals(Arrays.asList(1), solution.preorderTraversal(new TreeNode(1)));
  }

  @Test
  public void test123() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(Arrays.asList(1, 2, 3), solution.preorderTraversal(root));
  }

  @Test
  public void test12Left() throws Exception {
    TreeNode root = TreeNodes.getTreePreorder(1, 2);
    assertEquals(Arrays.asList(1, 2), solution.preorderTraversal(root));
  }
}
