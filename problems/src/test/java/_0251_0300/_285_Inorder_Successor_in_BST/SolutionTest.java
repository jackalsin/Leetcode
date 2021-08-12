package _0251_0300._285_Inorder_Successor_in_BST;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOne() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(null, solution.inorderSuccessor(root, root));
  }

}
