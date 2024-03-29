package byteDance._124_Binary_Tree_Maximum_Path_Sum;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 5/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(6, solution.maxPathSum(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(2, -1);
    assertEquals(2, solution.maxPathSum(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, -2, 3);
    assertEquals(4, solution.maxPathSum(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}