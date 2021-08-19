package _0101_0150._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/19/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void test3Nodes(Solution solution) {
    final int[] input = new int[]{1, 2, 3};
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1, 3);
    assertEquals(root, solution.sortedArrayToBST(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void test2Nodes(Solution solution) {
    final int[] input = new int[]{1, 2};
    final TreeNode root = TreeNodes.getTreeLevelOrder(2, 1);
    assertEquals(root, solution.sortedArrayToBST(input));
  }
}
