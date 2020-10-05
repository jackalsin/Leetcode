package hulu._337_House_Robber_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(Solution solution) throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(
        3,
        2, 3,
        null, 3, null, 1);
    assertEquals(7, solution.rob(root));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(3, 4, 5, 1, 3, null, 1);
    assertEquals(9, solution.rob(root));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}