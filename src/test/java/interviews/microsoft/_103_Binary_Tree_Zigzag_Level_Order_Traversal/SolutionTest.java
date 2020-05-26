package interviews.microsoft._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void test1Level() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @Test
  void test2Levels() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @Test
  void test3Levels() {
    final TreeNode input = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5, 6, 7);
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    expected.add(Arrays.asList(3, 2));
    expected.add(Arrays.asList(4, 5, 6, 7));
    assertEquals(expected, solution.zigzagLevelOrder(input));
  }

  @Test
  void testNullPointer() {
    assertEquals(new ArrayList<>(), solution.zigzagLevelOrder(null));
  }
}