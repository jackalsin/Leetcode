package _0451_0500._483_Smallest_Good_Base;

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
  public void testOnlineCase1() throws Exception {
    //    Explanation: 13 base 3 is 111.
    assertEquals("3", solution.smallestGoodBase("13"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    //    Explanation: 4681 base 8 is 11111.
    final String input = "4681";
    final String expected = "8";
    assertEquals(expected, solution.smallestGoodBase(input));

  }

  @Test
  public void testOnlineCase3() throws Exception {
    //    Explanation: 1000000000000000000 base 999999999999999999 is 11.
    final String input = "1000000000000000000";
    final String expected = "999999999999999999";
    assertEquals(expected, solution.smallestGoodBase(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String input = "14919921443713777";
    final String expected = "496";
//    System.out.println(Long.toString(Long.parseLong(input), 496));
    assertEquals(expected, solution.smallestGoodBase(input));
  }
}