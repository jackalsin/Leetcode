package explore._124_Binary_Tree_Maximum_Path_Sum;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/29/2020
 */
class SolutionITest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void test3(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(6, solution.maxPathSum(root));
  }

}