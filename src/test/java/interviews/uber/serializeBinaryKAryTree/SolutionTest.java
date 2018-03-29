package interviews.uber.serializeBinaryKAryTree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  /**
   *            a
   *         /  | \
   *         b  g  h
   *       / | \
   *      c  d  e
   *         |
   *         f
   */
  @Test
  void testOnlineCase1() {
    final TreeNode d = new TreeNode('d', new TreeNode('f'));
    final TreeNode b = new TreeNode('b', new TreeNode('c'), d, new TreeNode('e'));
    final TreeNode a = new TreeNode('a', b, new TreeNode('g'), new TreeNode('h'));
    final String output = Solution.serialize(a);
    System.out.println(output);

    final TreeNode actual = Solution.deserialize(output);

    assertEquals(a, actual);
  }
}