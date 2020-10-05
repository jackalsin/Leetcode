package _0901_0950._938_Range_Sum_of_BST;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(10, 5, 15, 3, 7, null, 18);
    final int L = 7, R = 15;
    assertEquals(32, solution.rangeSumBST(root, L, R));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(10, 5, 15, 3, 7, 13, 18, 1, null, 6);
    final int L = 6, R = 10;
    assertEquals(23, solution.rangeSumBST(root, L, R));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}