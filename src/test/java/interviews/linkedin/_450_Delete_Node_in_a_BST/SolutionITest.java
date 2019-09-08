package interviews.linkedin._450_Delete_Node_in_a_BST;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, 7);
    final TreeNode actual = solution.deleteNode(root, 3);
    Set<TreeNode> expected = Set.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 4, 6, 2, null, null, 7)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(5, 2, 6, null, 4, null, 7))
    );
    assertTrue(expected.contains(actual));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new DirectInsertSolution(),
        new DirectInsertSolutionI(),
        new SwapSolution()
    );
  }

}