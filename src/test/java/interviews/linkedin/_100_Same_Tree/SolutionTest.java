package interviews.linkedin._100_Same_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testValid(Solution solution) {
    final TreeNode p = TreeNodes.getTreeLevelOrder(2, 1, 3),
        q = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertTrue(solution.isSameTree(p, q));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testInvalid(Solution solution) {
    final TreeNode p = TreeNodes.getTreeLevelOrder(1, 2, null),
        q = TreeNodes.getTreeLevelOrder(1, null, 2);
    assertFalse(solution.isSameTree(p, q));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}