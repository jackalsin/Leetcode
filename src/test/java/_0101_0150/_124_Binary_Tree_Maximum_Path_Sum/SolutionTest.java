package _0101_0150._124_Binary_Tree_Maximum_Path_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/26/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(6, solution.maxPathSum(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test42(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(-10, 9, 20, null, null, 15, 7);
    assertEquals(42, solution.maxPathSum(root));
  }

}
