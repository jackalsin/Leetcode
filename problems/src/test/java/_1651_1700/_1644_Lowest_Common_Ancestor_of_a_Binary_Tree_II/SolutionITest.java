package _1651_1700._1644_Lowest_Common_Ancestor_of_a_Binary_Tree_II;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3,
        5, 1,
        6, 2, 0, 8,
        null, null, 7, 4);
    assertEquals(root, solution.lowestCommonAncestor(root, root.left, root.right));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3,
        5, 1,
        6, 2, 0, 8,
        null, null, 7, 4);
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left.right.right));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        3,
        5, 1,
        6, 2, 0, 8,
        null, null, 7, 4);
    assertNull(solution.lowestCommonAncestor(root, root.left, new TreeNode(10)));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}
