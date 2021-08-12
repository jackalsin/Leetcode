package _0101_0150._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

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

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3Levels(Solution solution) throws Exception {
    final int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] levelOrder = new int[]{4, 2, 6, 1, 3, 5, 7};
    final int[] postOrder = new int[]{1, 3, 2, 5, 7, 6, 4};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(inorder, postOrder));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

}
