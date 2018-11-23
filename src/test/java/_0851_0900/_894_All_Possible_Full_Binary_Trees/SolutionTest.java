package _0851_0900._894_All_Possible_Full_Binary_Trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase7() {
    final List<TreeNode> actual = solution.allPossibleFBT(7);

    assertEquals(5, actual.size());
  }

  @Test
  void testOnlineCase5() {
    final List<TreeNode> actual = solution.allPossibleFBT(5);

    assertEquals(2, actual.size());
  }

  @Test
  void testOnlineCase3() {
    final List<TreeNode> actual = solution.allPossibleFBT(3);

    assertEquals(1, actual.size());
    final TreeNode exp1 = new TreeNode(0);
    exp1.left = new TreeNode(0);
    exp1.right = new TreeNode(0);
    final List<TreeNode> expected = List.of(exp1);
    assertEquals(1, actual.size());
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase1() {
    final List<TreeNode> actual = solution.allPossibleFBT(1);
    assertEquals(1, actual.size());
    final List<TreeNode> expected = List.of(new TreeNode(0));
    assertEquals(1, actual.size());
    assertEquals(expected, actual);
  }
}