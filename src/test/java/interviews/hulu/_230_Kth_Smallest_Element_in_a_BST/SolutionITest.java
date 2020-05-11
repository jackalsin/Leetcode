package interviews.hulu._230_Kth_Smallest_Element_in_a_BST;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(1);
    assertEquals(1, solution.kthSmallest(root, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test4Level(Solution solution) {
    TreeNode root = TreeNodes.getTreeLevelOrder(4, 2, 6, 1, 3, 5, 7);
    for (int i = 1; i <= 7; i++) {
      assertEquals("k = " + i + " pass", i, solution.kthSmallest(root, i));
    }
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new NonCacheVersion(),
        new CacheVersion()
    );
  }
}