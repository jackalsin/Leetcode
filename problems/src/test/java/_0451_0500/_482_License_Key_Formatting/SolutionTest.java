package _0451_0500._482_License_Key_Formatting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/9/2017.
 */
public class SolutionTest {

  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String S = "5F3Z-2e-9-w", expected = "5F3Z-2E9W";
    final int K = 4;
    assertEquals(expected, solution.licenseKeyFormatting(S, K));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String S = "2-5g-3-J", expected = "2-5G-3J";
    final int K = 2;
    assertEquals(expected, solution.licenseKeyFormatting(S, K));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String s = "aaaa", expected = "AA-AA";
    assertEquals(expected, solution.licenseKeyFormatting(s, 2));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String s = "0123456789", e = "0-1-2-3-4-5-6-7-8-9";
    assertEquals(e, solution.licenseKeyFormatting(s, 1));
  }
}
