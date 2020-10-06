package _0951_1000._971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2);
    final int[] voyage = {2, 1};
    final List<Integer> expected = List.of(-1),
        actual = solution.flipMatchVoyage(root, voyage);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    final int[] voyage = {1, 3, 2};
    final List<Integer> expected = List.of(1),
        actual = solution.flipMatchVoyage(root, voyage);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    final int[] voyage = {1, 2, 3};
    final List<Integer> expected = List.of(),
        actual = solution.flipMatchVoyage(root, voyage);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(30, 26, 11, 1, 13, null, 8, 20, 19, 27, 3, null, 7, null, null,
        29, 25, null, 6, 28, null, 17, 18, 4, null, 21, 23, null, null, 12, null, null, 10, null, null, null, null, 9
        , 5, 16, 2, null, null, null, null, null, null, null, 15, null, 22, null, null, null, 14, 24);
    final int[] voyage = {30, 13, 8, 7, 17, 10, 18, 26, 11, 3, 28, 12, 27, 6, 1, 19, 29, 4, 25, 21, 5, 15, 14, 9, 23,
        2, 16, 22, 24, 20};
    final List<Integer> expected = List.of(-1),
        actual = solution.flipMatchVoyage(root, voyage);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}