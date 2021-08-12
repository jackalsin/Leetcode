package example.tree;

import definition.binaryTree.TreeNode;
import definition.binaryTree.TreeNodes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InOrderTraversalTest {
  private Traversal traversal;

  @BeforeEach
  public void setUp() throws Exception {
    traversal = new InOrderTraversal();
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