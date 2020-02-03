package _0551_0600._563_Binary_Tree_Tilt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3);
    assertEquals(1, solution.findTilt(root));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}