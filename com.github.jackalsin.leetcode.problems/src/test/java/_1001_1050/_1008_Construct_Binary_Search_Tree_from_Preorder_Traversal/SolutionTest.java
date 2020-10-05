package _1001_1050._1008_Construct_Binary_Search_Tree_from_Preorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[] input = {8, 5, 1, 7, 10, 12};
    final TreeNode expected = TreeNodes.getTreeLevelOrder(8, 5, 10, 1, 7, null, 12),
        actual = solution.bstFromPreorder(input);
    assertEquals(expected, actual);
  }
}