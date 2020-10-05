package linkedin._1028_Recover_a_Tree_From_Preorder_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "1-2--3--4-5--6--7";
    final TreeNode expected = TreeNodes.getTreeLevelOrder(1, 2, 5, 3, 4, 6, 7),
        actual = solution.recoverFromPreorder(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "1-2--3---4-5--6---7";
    final TreeNode expected = TreeNodes.getTreeLevelOrder(1, 2, 5, 3, null, 6),
        actual = solution.recoverFromPreorder(input);
    expected.left.left.left = new TreeNode(4);
    expected.right.left.left = new TreeNode(7);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "1-401--349---90--88";
    final TreeNode expected = TreeNodes.getTreeLevelOrder(1, 401, null, 349, 88),
        actual = solution.recoverFromPreorder(input);
    expected.left.left.left = new TreeNode(90);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}