package _051_100._067_Add_Binary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/26/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithNoCarry() throws Exception {
    String a = "1";
    String b = "1";
    assertEquals("10", solution.addBinary(a, b));
  }

  @Test
  public void testWithCarry() throws Exception {
    String a = "1";
    String b = "0";
    assertEquals("1", solution.addBinary(a, b));
  }

  @Test
  public void testWithDifferentLens() throws Exception {
    String a = "11";
    String b = "1";
    assertEquals("100", solution.addBinary(a, b));
  }
}