package interviews.microsoft._112_Path_Sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testInCompletedTreeTrue() {
    final TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    assertTrue(solution.hasPathSum(root, 3));
  }

  @Test
  public void testInCompletedTreeFalse() {
    final TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    assertFalse(solution.hasPathSum(root, 1));
  }

  @Test
  public void ftestNull() {
    assertFalse(solution.hasPathSum(null, 1));
  }
}