package _351_400._366_Find_Leaves_of_Binary_Tree;

import org.junit.Before;
import org.junit.Test;

import java.awt.desktop.AboutEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utils.TreeNode;
import utils.TreeNodes;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/13/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    TreeNode root = TreeNodes.getTreeLevelOrder(1, 2, 3, 4, 5);
    List<Set<Integer>> expected = List.of(Set.of(4, 5, 3), Set.of(2), Set.of(1));
    List<List<Integer>> actual = solution.findLeaves(root);
    for (int i = 0; i < actual.size(); ++i) {
      assertEquals(expected.get(i), new HashSet<>(actual.get(i)));
    }
    assertEquals(expected.size(), actual.size());
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(new ArrayList<>(), solution.findLeaves(null));
  }

}
