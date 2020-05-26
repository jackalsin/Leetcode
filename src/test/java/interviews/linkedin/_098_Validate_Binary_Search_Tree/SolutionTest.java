package interviews.linkedin._098_Validate_Binary_Search_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testValid(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertTrue(solution.isValidBST(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testInvalid(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertFalse(solution.isValidBST(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testEmpty(Solution solution) {
    assertTrue(solution.isValidBST(null));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new StackSolution(),
        new StackSolutionI(),
        new MorrisTraversalSolution(),
        new StackSolutionII(),
        new DfsSolution()
    );
  }
}