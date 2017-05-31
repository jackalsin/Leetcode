package _051_100._091_Decode_Ways;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/31/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testZeroElement() throws Exception {
    assertEquals(0, solution.numDecodings(""));
  }

  @Test
  public void testOneElement() throws Exception {
    assertEquals(1, solution.numDecodings("1"));
  }

  @Test
  public void test01() throws Exception {
    assertEquals(0, solution.numDecodings("01"));
  }

  @Test
  public void test10() throws Exception {
    assertEquals(1, solution.numDecodings("10"));
  }
}
