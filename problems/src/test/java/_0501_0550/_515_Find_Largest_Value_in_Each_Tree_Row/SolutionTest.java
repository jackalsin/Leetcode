package _0501_0550._515_Find_Largest_Value_in_Each_Tree_Row;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 3, 2, 5, 3, 9);
    assertEquals(List.of(1, 3, 9), solution.largestValues(root));
  }

}
