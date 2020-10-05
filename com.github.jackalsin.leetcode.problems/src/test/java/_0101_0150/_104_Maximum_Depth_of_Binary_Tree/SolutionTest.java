package _0101_0150._104_Maximum_Depth_of_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 6/16/2017.
 */
public class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1Level(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.maxDepth(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2Levels(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(2, solution.maxDepth(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3LevelsIncomplete(Solution solution) {
    TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4);
    assertEquals(3, solution.maxDepth(input));
  }
}
