package _0351_0400._393_UTF_8_Validation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/10/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    //11000101 10000010 00000001
    final int[] data = {197, 130, 1};
    assertTrue(solution.validUtf8(data));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] data = {235, 140, 4};
    assertFalse(solution.validUtf8(data));
  }

  @Test
  public void testFailedOn255() throws Exception {
    final int[] data = {255};
    assertFalse(solution.validUtf8(data));
  }

  @Test
  public void testOn145() throws Exception {
    final int[] data = {145};
    //    10010001
    displayBinaryString(data);
    assertFalse(solution.validUtf8(data));
  }

  @Test
  public void testFailOn() throws Exception {
    // 11100110 10001000 10010001
    final int[] data = {230, 136, 145};
    displayBinaryString(data);
    assertTrue(solution.validUtf8(data));
  }

  private static void displayBinaryString(final int[] data) {
    for (int d : data) {
      System.out.print(Integer.toBinaryString(d) + " ");
    }
  }
}
