package interviews.linkedin._205_Isomorphic_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String s = "egg";
    final String t = "add";
    assertTrue(solution.isIsomorphic(s, t));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String s = "foo";
    final String t = "bar";
    assertFalse(solution.isIsomorphic(s, t));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String s = "paper";
    final String t = "title";
    assertTrue(solution.isIsomorphic(s, t));
  }

}
