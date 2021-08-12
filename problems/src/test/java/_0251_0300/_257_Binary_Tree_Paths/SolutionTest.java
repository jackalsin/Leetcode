package _0251_0300._257_Binary_Tree_Paths;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/26/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNull() throws Exception {
    assertEquals(new ArrayList<>(), solution.binaryTreePaths(null));
  }

  @Test
  public void testOnlineCase() throws Exception {
    final TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, null, 5);
    final List<String> actual = solution.binaryTreePaths(root);
    final Set<String> expected = new HashSet<>();
    expected.add("1->2->5");
    expected.add("1->3");
    assertEquals(expected, new HashSet<>(actual));
  }
}
