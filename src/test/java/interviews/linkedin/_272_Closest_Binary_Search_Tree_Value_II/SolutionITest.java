package interviews.linkedin._272_Closest_Binary_Search_Tree_Value_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/20/18
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testEmpty(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    assertEquals(new ArrayList<>(), solution.closestKValues(root, 8, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testBalanced(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    final List<Integer> expected = Arrays.asList(3, 4, 2, 5, 1);
    assertEquals(expected, solution.closestKValues(root, 3.4, 5));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(3, 1, 4, null, 2);
    final List<Integer> expected = Collections.singletonList(2);
    assertEquals(expected, solution.closestKValues(root, 2.00000, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(5, 3, 6, 2, 4, null, null, 1);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
    assertEquals(expected, solution.closestKValues(root, 0.857143, 5));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}