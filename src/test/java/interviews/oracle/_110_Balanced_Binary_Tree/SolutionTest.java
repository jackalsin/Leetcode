package interviews.oracle._110_Balanced_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test1Level(Solution solution) {
    TreeNode root = new TreeNode(1);
    assertTrue(solution.isBalanced(root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test0Level(Solution solution) {
    assertTrue(solution.isBalanced(null));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2LevelsBalanced(Solution solution) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test2LevelsBalanced1Diff(Solution solution) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(3);
    assertTrue(solution.isBalanced(root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void test3LevelsBalanced1Diff(Solution solution) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(3);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(2);
    assertTrue(solution.isBalanced(root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNotBalanced(Solution solution) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    root.right.right.right = new TreeNode(4);
    assertFalse(solution.isBalanced(root));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}