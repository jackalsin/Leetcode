package _0101_0150._114_Flatten_Binary_Tree_to_Linked_List;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 5, 3, 4, null, 6);
    solution.flatten(input);
    TreeNode expected = new TreeNode(1);
      expected.right = new TreeNode(2);
        expected.right.right = new TreeNode(3);
          expected.right.right.right = new TreeNode(4);
            expected.right.right.right.right = new TreeNode(5);
              expected.right.right.right.right.right = new TreeNode(6);
    assertEquals(expected, input);
  }
}
