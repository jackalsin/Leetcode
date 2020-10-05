package oracle._617_Merge_Two_Binary_Trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/24/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode t1 = TreeNodes.getTreeLevelOrder(1, 3, 2, 5),
        t2 = TreeNodes.getTreeLevelOrder(2, 1, 3, null, 4, null, 7),
        expected = TreeNodes.getTreeLevelOrder(3, 4, 5, 5, 4, null, 7);
    final TreeNode actual = solution.mergeTrees(t1, t2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}