package google._951_Flip_Equivalent_Binary_Trees;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final TreeNode root1 = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, null, null, null, 7, 8),
        root2 = TreeNodes.getTreeLevelOrder(1, 3, 2, null, 6, 4, 5, null, null, null, null, 8, 7);
    assertTrue(solution.flipEquiv(root1, root2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}