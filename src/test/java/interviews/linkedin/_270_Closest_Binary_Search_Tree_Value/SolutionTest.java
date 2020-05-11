package interviews.linkedin._270_Closest_Binary_Search_Tree_Value;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{4, 2, 5, 1, 3});
    final double target = 3.714286;
    assertEquals(4, solution.closestValue(root, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(new int[]{0});
    final double target = Integer.MAX_VALUE;
    assertEquals(0, solution.closestValue(root, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, null, 2);
    final double target = Integer.MAX_VALUE;
    assertEquals(2, solution.closestValue(root, target));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}