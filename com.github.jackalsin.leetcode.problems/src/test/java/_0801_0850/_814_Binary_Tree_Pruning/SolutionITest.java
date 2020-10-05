package _0801_0850._814_Binary_Tree_Pruning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = new TreeNode(1);
    root.right = TreeNodes.getTreeLevelOrder(0, 0, 1);
    final TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(0);
    expected.right.right = new TreeNode(1);
    assertEquals(expected, solution.pruneTree(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = new TreeNode(1);
    root.right = TreeNodes.getTreeLevelOrder(0, 0, 1);
    final TreeNode expected = new TreeNode(1);
    expected.right = new TreeNode(0);
    expected.right.right = new TreeNode(1);
    assertEquals(expected, solution.pruneTree(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}