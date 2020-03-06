package _0601_0650._623_Add_One_Row_to_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.Objects;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/5/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode expected = TreeNodes.getTreeLevelOrder(
        4,
        1, 1,
        2, null, null, 6,
        3, 1, 5
    ), input = new TreeNode(Objects.requireNonNull(expected));
    input.left = input.left.left;
    input.right = input.right.right;
    final TreeNode actual = solution.addOneRow(input, 1, 2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}