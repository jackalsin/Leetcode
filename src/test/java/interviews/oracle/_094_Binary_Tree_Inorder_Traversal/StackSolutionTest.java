package interviews.oracle._094_Binary_Tree_Inorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
class StackSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBalancedTree(Solution solution) {
    final TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new StackSolution(),
        new MorrisSolution()
    );
  }
}