package _0551_0600._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees.Node;
import definition._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees.Nodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final int[][] quadTree1 = {{0, 1}, {1, 1}, {1, 1}, {1, 0}, {1, 0}},
        quadTree2 = {{0, 1}, {1, 1}, {0, 1}, {1, 1}, {1, 0}, null, null, null, null, {1, 0}, {1, 0}, {1, 1}, {1, 1}},
        expected = {{0, 0}, {1, 1}, {1, 1}, {1, 1}, {1, 0}};
    final Node tree1 = Nodes.get(quadTree1), tree2 = Nodes.get(quadTree2),
        expectTree = Nodes.get(expected), actual = solution.intersect(tree1, tree2);
    assertEquals(expectTree, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}