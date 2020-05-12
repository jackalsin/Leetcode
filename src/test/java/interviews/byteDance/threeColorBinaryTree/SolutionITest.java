package interviews.byteDance.threeColorBinaryTree;

import interviews.byteDance.threeColorBinaryTree.SolutionI.TreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input = "1122002010";
    final int[] expected = {2, 5}, actual = solution.minMaxGreenColor(input);
    assertArrayEquals(expected, actual, String.format("Expecting %s, but actual = %s",
        Arrays.toString(expected), Arrays.toString(actual)));
  }

  // test of build tree
  @Test
  void testBuildTree1() {
    final SolutionI solution = new SolutionI();
    final String input = "21200110";
    final TreeNode actual = solution.buildTree(input),
        expected = new TreeNode();
    expected.left = new TreeNode();
    expected.left.left = new TreeNode();
    expected.left.left.left = new TreeNode();
    expected.left.left.right = new TreeNode();
    expected.right = new TreeNode();
    expected.right.left = new TreeNode();
    expected.right.left.left = new TreeNode();
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}