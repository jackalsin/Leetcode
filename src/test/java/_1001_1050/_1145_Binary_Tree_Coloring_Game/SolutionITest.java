package _1001_1050._1145_Binary_Tree_Coloring_Game;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    final int n = 11, x = 3;
    assertTrue(solution.btreeGameWinningMove(root, n, x));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    //                8
    //          6           7
    //    3        4             9
    //      2     5   null    null  null
    //    n   n  n  1
    final TreeNode root = TreeNodes.getTreeLevelOrder(8, 6, 7, 3, 4, null, 9, null, 2, 5, null, null, null, null,
        null, null, 1);
    final int n = 9, x = 4;
    assertTrue(solution.btreeGameWinningMove(root, n, x));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}