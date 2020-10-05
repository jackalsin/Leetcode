package linkedin._101_Symmetric_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/19/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, 3, 4, 4, 3);
    assertTrue(solution.isSymmetric(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testThreeLevelTree(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, 3, 4, 4, 3, 5, 6, 7, 8, 8, 7, 6, 5);
    assertTrue(solution.isSymmetric(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed1(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 2, null, 3, null, 3);
    assertFalse(solution.isSymmetric(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
