package interviews.oracle._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/16/2019
 */
class SolutionITest {
  private TreeNode root = TreeNodes.getTreeLevelOrder(3, 5, 1, 6, 2, 0, 8);

  @BeforeEach
  void setUp() {
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(3, solution.lowestCommonAncestor(root, root.left, root.right).val);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    assertEquals(5, solution.lowestCommonAncestor(root, root.left, root.left.right.right).val);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

}