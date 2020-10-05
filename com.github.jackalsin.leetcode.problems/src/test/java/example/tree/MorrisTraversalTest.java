package example.tree;

import org.junit.Before;
import org.junit.Test;
import utils.binaryTree.TreeNode;
import utils.binaryTree.TreeNodes;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class MorrisTraversalTest {
  private Traversal traversal;

  @Before
  public void setUp() throws Exception {
    traversal = new MorrisTraversal();
  }

  @Test
  public void testFullBalancedTree() {
    final TreeNode root = TreeNodes.getTreeLevelOrder(
        8,
        4, 12,
        2, 6, 10, 14,
        1, 3, 5, 7, 9, 11, 13, 15
    );
    List<Integer> actual = traversal.traverse(root);
    final List<Integer> expected = new ArrayList<>();
    for (int i = 1; i < 16; i++) {
      expected.add(i);
    }
    assertEquals(expected, actual);
  }
}