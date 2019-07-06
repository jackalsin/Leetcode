package interviews.linkedin._156_Binary_Tree_Upside_Down;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOneElement(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1);
    TreeNode expected = TreeNodes.getTreeLevelOrder(1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoElements(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, null);
    TreeNode expected = TreeNodes.getTreeLevelOrder(2, null, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testTwoLevelsFull(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    TreeNode expected = TreeNodes.getTreeLevelOrder(2, 3, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testThreeLevels(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, null, null);
    TreeNode expected = TreeNodes.getTreeLevelOrder(4, 5, 2, null, null, 3, 1);
    assertEquals(expected, solution.upsideDownBinaryTree(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}