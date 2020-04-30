package explore.Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves_Path_in_a_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/30/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0);
    final int[] arr = {0, 1, 0, 1};
    assertTrue(solution.isValidSequence(root, arr));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0);
    final int[] arr = {0, 0, 1};
    assertFalse(solution.isValidSequence(root, arr));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(0, 1, 0, 0, 1, 0, null, null, 1, 0, 0);
    final int[] arr = {0, 1, 1};
    assertFalse(solution.isValidSequence(root, arr));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}