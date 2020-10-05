package byteDance._094_Binary_Tree_Inorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBalancedTree(Solution solution) {
    final TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(List.of(), solution.inorderTraversal(null));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new MorrisTraversalSolution()
    );
  }
}