package _0951_1000._988_Smallest_String_Starting_From_Leaf;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, 1, 2, 3, 4, 3, 4);
    final String expected = "dba", actual = solution.smallestFromLeaf(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(25, 1, 3, 1, 3, 0, 2);
    final String expected = "adz", actual = solution.smallestFromLeaf(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 2, 1, null, 1, 0, null, 0);
    final String expected = "abc", actual = solution.smallestFromLeaf(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    final String expected = "hud", actual = solution.smallestFromLeaf(root);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}