package _0951_1000._987_Vertical_Order_Traversal_of_a_Binary_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    final List<List<Integer>> expected = List.of(
        List.of(9),
        List.of(3, 15),
        List.of(20),
        List.of(7)
    ), actual = solution.verticalTraversal(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7);
    final List<List<Integer>> expected = List.of(
        List.of(4),
        List.of(2),
        List.of(1, 5, 6),
        List.of(3),
        List.of(7)
    ), actual = solution.verticalTraversal(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, null, 1, 2, 3, null, null, 4, 5);
    final List<List<Integer>> expected = List.of(
        List.of(0, 2),
        List.of(1, 4),
        List.of(3),
        List.of(5)
    ), actual = solution.verticalTraversal(root);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        0, 5, 1, 9, null, 2, null, null, null, null, 3, 4, 8, 6, null, null, null, 7);
    final List<List<Integer>> expected = List.of(
        List.of(9, 7),
        List.of(5, 6),
        List.of(0, 2, 4),
        List.of(1, 3),
        List.of(8)
    ), actual = solution.verticalTraversal(root);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}