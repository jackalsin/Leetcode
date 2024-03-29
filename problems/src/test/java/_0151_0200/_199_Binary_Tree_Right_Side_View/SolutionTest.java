package _0151_0200._199_Binary_Tree_Right_Side_View;


import definition.binaryTree.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 8/4/2017.
 */
class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    List<Integer> result = Arrays.asList(1, 3, 4);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(4);
    assertEquals(result, solution.rightSideView(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testPenetrateTestCase(Solution solution) {
    List<Integer> result = Arrays.asList(1, 3, 5);
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.right = new TreeNode(5);
    assertEquals(result, solution.rightSideView(root));
  }
}
