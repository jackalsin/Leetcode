package _1001_1050._1022_Sum_of_Root_To_Leaf_Binary_Numbers;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 0, 1, 0, 1, 0, 1);
    final int expected = 22, actual = solution.sumRootToLeaf(input);
    assertEquals(expected, actual);
//    Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1);
    final int expected = 1, actual = solution.sumRootToLeaf(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 1);
    final int expected = 3, actual = solution.sumRootToLeaf(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(0);
    final int expected = 0, actual = solution.sumRootToLeaf(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}