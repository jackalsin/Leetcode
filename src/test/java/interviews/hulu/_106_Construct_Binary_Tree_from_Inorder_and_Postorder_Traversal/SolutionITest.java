package interviews.hulu._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3Levels(Solution solution) throws Exception {
    final int[] inorder = new int[]{1, 2, 3, 4, 5, 6, 7};
    final int[] levelOrder = new int[]{4, 2, 6, 1, 3, 5, 7};
    final int[] postOrder = new int[]{1, 3, 2, 5, 7, 6, 4};
    final TreeNode root = TreeNodes.getTreeLevelOrder(levelOrder);
    assertEquals(root, solution.buildTree(inorder, postOrder));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3Levels2(Solution solution) throws Exception {
    final int[] inorder = new int[]{9, 3, 15, 20, 7};
    final int[] postOrder = new int[]{9, 15, 7, 20, 3};
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 9, 20, null, null, 15, 7);
    assertEquals(root, solution.buildTree(inorder, postOrder));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}