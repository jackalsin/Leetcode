package _1001_1050._1038_Binary_Search_Tree_to_Greater_Sum_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 10/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8),
        expected = TreeNodes.getTreeLevelOrder(30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8);
    assertEquals(expected, solution.bstToGst(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(0, null, 1),
        expected = TreeNodes.getTreeLevelOrder(1, null, 1);
    assertEquals(expected, solution.bstToGst(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 0, 2),
        expected = TreeNodes.getTreeLevelOrder(3, 3, 2);
    assertEquals(expected, solution.bstToGst(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(3, 2, 4, 1),
        expected = TreeNodes.getTreeLevelOrder(7, 9, 4, 10);
    assertEquals(expected, solution.bstToGst(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}