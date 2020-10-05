package _0701_0750._742_Closest_Leaf_in_a_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 5/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 3, 2);
    assertTrue(Set.of(2, 3).contains(solution.findClosestLeaf(root, 1)));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.findClosestLeaf(root, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, null, null, null, 5, null, 6);
    assertEquals(3, solution.findClosestLeaf(root, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, null, null, 4, 5, 6, null, null, 7, 8, 9, 10);
    assertEquals(10, solution.findClosestLeaf(root, 7));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}