package _0051_0100._065_Valid_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithSpace() throws Exception {
    assertTrue(solution.isNumber(" 33"));
  }

  @Test
  public void testWithZero() throws Exception {
    assertTrue(solution.isNumber("0000"));
  }

  @Test
  public void testWithPoint() throws Exception {
    assertTrue(solution.isNumber("0.3"));
    assertTrue(solution.isNumber(".3"));
    assertTrue(solution.isNumber("-0.3"));
    assertTrue(solution.isNumber("-.3"));
  }

  @Test
  public void testWithEmpty() throws Exception {
    assertFalse(solution.isNumber(""));
  }

  @Test
  public void testWithExpanation() throws Exception {
    assertTrue(solution.isNumber("3e2"));
    assertFalse(solution.isNumber("3e0.3"));
    assertTrue(solution.isNumber("3e-2"));
  }

  @Test
  public void testWithFailedTestCase() throws Exception {
    // leetcode's brain is broken
    assertTrue(solution.isNumber("3."));
    assertFalse(solution.isNumber("."));
    assertFalse(solution.isNumber("-."));
    assertTrue(solution.isNumber("46.e3"));
    assertFalse(solution.isNumber("e3"));
    assertFalse(solution.isNumber("46.e"));
    assertTrue(solution.isNumber(".2e81"));
  }

}
