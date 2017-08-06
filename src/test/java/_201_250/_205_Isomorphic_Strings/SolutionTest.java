package _201_250._205_Isomorphic_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/6/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() {
    assertTrue(solution.isIsomorphic("", ""));
  }

  @Test
  public void testExample1() {
    assertTrue(solution.isIsomorphic("egg", "add"));
  }

  @Test
  public void testExample2() {
    assertFalse(solution.isIsomorphic("foo", "bar"));
  }

  @Test
  public void testExample3() {
    assertTrue(solution.isIsomorphic("paper", "title"));
  }

  @Test
  public void testAbAndAA() throws Exception {
    assertFalse(solution.isIsomorphic("ab", "aa"));
  }
}
