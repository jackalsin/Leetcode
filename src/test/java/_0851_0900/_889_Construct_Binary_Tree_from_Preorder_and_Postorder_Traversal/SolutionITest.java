package _0851_0900._889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final int[] pre = {1, 2, 4, 5, 3, 6, 7}, post = {4, 5, 2, 6, 7, 3, 1};
    final TreeNode expected = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7),
        actual = solution.constructFromPrePost(pre, post);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final int[] pre = {1, 2}, post = {2, 1};
    final TreeNode expected = TreeNodes.getTreeLevelOrder(1, 2),
        actual = solution.constructFromPrePost(pre, post);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}