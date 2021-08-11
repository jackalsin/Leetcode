package linkedin._337_House_Robber_III;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/11/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 2, 3, null, 3, null, 1);
    assertEquals(7, solution.rob(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 3, null, 1);
    assertEquals(9, solution.rob(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(41, 37, 44, 24, 39, 42, 48, 1, 35, 38, 40, null, 43, 46, 49, 0, 2, 30
        , 36, null, null, null, null, null, null, 45, 47, null, null, null, null, null, 4, 29, 32, null, null, null,
         null
        , null, null, 3, 9, 26, null, 31, 34, null, null, 7, 11, 25, 27, null, null, 33, null, 6, 8, 10, 16, null, null,
        null, 28, null, null, 5, null, null, null, null, null, 15, 19, null, null, null, null, 12, null, 18, 20, null,
        13, 17, null, null, 22, null, 14, null, null, 21, 23);
    assertEquals(690, solution.rob(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}