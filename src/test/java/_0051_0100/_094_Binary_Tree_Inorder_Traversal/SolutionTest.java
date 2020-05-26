package _0051_0100._094_Binary_Tree_Inorder_Traversal;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBalancedTree(Solution solution) throws Exception {
    final TreeNode root = new TreeNode(1);
    root.left = null;
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    assertEquals(Arrays.asList(1, 3, 2), solution.inorderTraversal(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

}
