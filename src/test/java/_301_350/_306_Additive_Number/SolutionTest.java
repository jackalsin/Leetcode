package _301_350._306_Additive_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/13/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "112358";
    assertTrue(solution.isAdditiveNumber(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "199100199";
    assertTrue(solution.isAdditiveNumber(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "1203";
    assertFalse(solution.isAdditiveNumber(input));
  }


  @Test
  public void testFailed1() throws Exception {
    final String input = "111122335588143";
    assertTrue(solution.isAdditiveNumber(input));
  }

  @Test
  public void testFailed2() throws Exception {
    final String input = "0235813";
    assertFalse(solution.isAdditiveNumber(input));

  }
  @Test
  public void testFailed3() throws Exception {
    final String input = "12012122436";
    assertTrue(solution.isAdditiveNumber(input));

  }

  @Test
  public void testFailed4() throws Exception {
    final String input = "198019823962";
    assertTrue(solution.isAdditiveNumber(input));

  }
}
