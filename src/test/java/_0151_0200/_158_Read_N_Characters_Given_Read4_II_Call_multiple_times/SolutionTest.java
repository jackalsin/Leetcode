package _0151_0200._158_Read_N_Characters_Given_Read4_II_Call_multiple_times;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testAbc() throws Exception {
    final String s = "abc";
    solution = new Solution(s);
    assertEquals(1, solution.read(new char[1], 1));
    assertEquals(3, solution.read(new char[4], 4));
    assertEquals(0, solution.read(new char[0], 0));
  }
}
