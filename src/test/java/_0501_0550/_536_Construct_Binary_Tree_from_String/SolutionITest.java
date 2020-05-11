package _0501_0550._536_Construct_Binary_Tree_from_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/26/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "4(2(3)(1))(6(5))";
    final TreeNode expected = TreeNodes.getTreeLevelOrder(
        4,
        2, 6,
        3, 1, 5
    );
    assertEquals(expected, solution.str2tree(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "-4(2(3)(1))(6(5)(7))";
    final TreeNode expected = TreeNodes.getTreeLevelOrder(
        -4,
        2, 6,
        3, 1, 5, 7
    ), actual = solution.str2tree(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}