package _051_100._071_Simplify_Path;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/28/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void  testWithRoot() throws Exception {
    assertEquals("/", solution.simplifyPath("/"));
  }

  @Test
  public void  testWithRootSimple() throws Exception {
    assertEquals("/", solution.simplifyPath("/c/c/../../"));
  }

  @Test
  public void test1() throws Exception {
    assertEquals("/c/e", solution.simplifyPath("/c/./c/../e"));
  }

  @Test
  public void testMissed1() throws Exception {
    assertEquals("/", solution.simplifyPath("/.."));
  }
}