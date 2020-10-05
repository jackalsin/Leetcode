package _0051_0100._098_Validate_Binary_Search_Tree;

import definition.binaryTree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 6/6/2017.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test213(Solution solution) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isValidBST(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test123(Solution solution) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    assertFalse(solution.isValidBST(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(Solution solution) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(14);
    root.left.left = new TreeNode(1);
    assertFalse(solution.isValidBST(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new MorrisTraversalSolution(),
        new StackSolution()
    );
  }
}