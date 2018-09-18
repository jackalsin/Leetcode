package interviews.linkedin._199_Binary_Tree_Right_Side_View;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    List<Integer> result = Arrays.asList(1, 3, 4);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    assertEquals(result, solution.rightSideView(root));
  }

  @Test
  void testPenetrateTestCase() throws Exception {
    List<Integer> result = Arrays.asList(1, 3, 5);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    assertEquals(result, solution.rightSideView(root));
  }
}