package microsoft._116_Populating_Next_Right_Pointers_in_Each_Node;

import definition.TreeLinkNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    TreeLinkNode expected = new TreeLinkNode(1);
    expected.left = new TreeLinkNode(2);
    expected.right = new TreeLinkNode(3);
    expected.left.next = expected.right;

    expected.left.left = new TreeLinkNode(4);
    expected.left.right = new TreeLinkNode(5);
    expected.right.left = new TreeLinkNode(6);
    expected.right.right = new TreeLinkNode(7);

    expected.left.left.next = expected.left.right;
    expected.left.right.next = expected.right.left;
    expected.right.left.next = expected.right.right;

    TreeLinkNode root = new TreeLinkNode(1);
    root.left = new TreeLinkNode(2);
    root.right = new TreeLinkNode(3);

    root.left.left = new TreeLinkNode(4);
    root.left.right = new TreeLinkNode(5);
    root.right.left = new TreeLinkNode(6);
    root.right.right = new TreeLinkNode(7);
    solution.connect(root);

    assertEquals(expected, root);
  }
}