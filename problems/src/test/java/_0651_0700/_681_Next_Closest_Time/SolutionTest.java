package _0651_0700._681_Next_Closest_Time;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "19:34";
    assertEquals("19:39", solution.nextClosestTime(input));
  }

  /**
   * 当寻找下一个更大的数字的时候也可能超过limit
   */
  @Test
  public void testFailedCase1() throws Exception {
    final String input = "23:59";
    assertEquals("22:22", solution.nextClosestTime(input));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String input = "01:32";
    assertEquals("01:33", solution.nextClosestTime(input));
  }

  @Test
  public void testGetNext() throws Exception {
    assertEquals(11, solution.getNextPermutation(List.of(1, 2, 3), 23, 24));
  }
}
