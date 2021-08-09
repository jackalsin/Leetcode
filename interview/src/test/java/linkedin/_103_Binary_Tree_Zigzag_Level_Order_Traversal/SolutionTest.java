package linkedin._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1Level(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test2Levels(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test3Levels(Solution solution) {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    expected.add(Arrays.asList(4, 5, 6, 7));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testNullPointer(Solution solution) {
    assertEquals(new ArrayList<>(), solution.zigzagLevelOrder(null));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}