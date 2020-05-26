package interviews.linkedin._671_Second_Minimum_Node_In_a_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 5, null, null, 5, 7);
    assertEquals(5, solution.findSecondMinimumValue(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 2);
    assertEquals(-1, solution.findSecondMinimumValue(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        1,
        1, 3,
        1, 1, 3, 4,
        3, 1, 1, 1, 3, 8, 4, 8,
        3, 3, 1, 6, 2, 1);
    assertEquals(2, solution.findSecondMinimumValue(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}
