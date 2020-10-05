package _0201_0250._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.binaryTree.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 8/18/2017.
 */
class SolutionTest {
  private static final TreeNode root = new TreeNode(6);

  SolutionTest() {
  }

  @BeforeEach
  void setUp() {
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);
    root.right = new TreeNode(8);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testPEqualsQRoot(Solution solution) {
    assertEquals(root, solution.lowestCommonAncestor(root, root, root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testPEqualsQNonRoot(Solution solution) {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left, root.left));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testParent(Solution solution) {
    assertEquals(root.left.right, solution.lowestCommonAncestor(root, root.left.right,
        root.left.right.right));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testRegular(Solution solution) {
    assertEquals(root.left, solution.lowestCommonAncestor(root, root.left.left,
        root.left.right.right));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

}
