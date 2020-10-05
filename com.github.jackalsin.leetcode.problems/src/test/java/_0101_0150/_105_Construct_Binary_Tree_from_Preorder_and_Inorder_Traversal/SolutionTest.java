package _0101_0150._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/18/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ONSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testEmpty(Solution solution) {
    assertEquals(null, solution.buildTree(new int[]{}, new int[]{}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3Levels(Solution solution) {
    final int[] preOrder = new int[]{1, 2, 4, 5, 3, 6, 7};
    final int[] levelOrder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] inOrder = new int[]{4, 2, 5, 1, 6, 3, 7};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(preOrder, inOrder));
  }
}