package interviews.google.kth_node;

import org.junit.Before;
import org.junit.Test;

import interviews.google.kth_node.Solution.TreeNode;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/22/2018.
 */
public class SolutionTest {
  private Solution solution;

  private static final TreeNode ROOT = new TreeNode(3, 6);

  static {
    ROOT.left = new TreeNode(2, 1);
    ROOT.left.left = new TreeNode(1, 0);
    ROOT.right = new TreeNode(5, 3);
    ROOT.right.left = new TreeNode(4, 0);
    ROOT.right.right = new TreeNode(6, 1);
    ROOT.right.right.right = new TreeNode(7, 0);
  }

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertEquals(1, solution.kthNode(ROOT, 1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(2, solution.kthNode(ROOT, 2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(3, solution.kthNode(ROOT, 3));
  }

  @Test
  public void test4() throws Exception {
    assertEquals(4, solution.kthNode(ROOT, 4));
  }

  @Test
  public void test5() throws Exception {
    assertEquals(5, solution.kthNode(ROOT, 5));
  }

  @Test
  public void test6() throws Exception {
    assertEquals(6, solution.kthNode(ROOT, 6));
  }

  @Test
  public void test7() throws Exception {
    assertEquals(7, solution.kthNode(ROOT, 7));
  }
}
