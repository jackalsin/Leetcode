package airbnb._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhixi
 * @version 1.0 on 8/18/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3Nodes(Solution solution) {
    final int[] input = {1, 2, 3};
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(root, solution.sortedArrayToBST(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2Nodes(Solution solution) {
    final int[] input = {1, 2};
    final Set<TreeNode> expectedSet = Set.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(1, null, 2)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(2, 1))
    );
    final TreeNode actual = solution.sortedArrayToBST(input);
    assertTrue(expectedSet.contains(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    final int[] input = {-10, -3, 0, 5, 9};
    final Set<TreeNode> expectedSet = Set.of(
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(0, -3, 9, -10, null, 5)),
        Objects.requireNonNull(TreeNodes.getTreeLevelOrder(0, -10, 5, null, -3, null, 9))
    );
    final TreeNode actual = solution.sortedArrayToBST(input);
    assertTrue(expectedSet.contains(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}