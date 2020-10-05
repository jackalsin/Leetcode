package _0151_0200._171_Excel_Sheet_Column_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testSingle() {
    assertEquals(26, solution.titleToNumber("Z"));
    assertEquals(1, solution.titleToNumber("A"));
  }

  @Test
  public void testDouble() {
    assertEquals(27, solution.titleToNumber("AA"));
    assertEquals(52, solution.titleToNumber("AZ"));
  }
}