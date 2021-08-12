package _0351_0400._400_Nth_Digit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.findNthDigit(3));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(0, solution.findNthDigit(11));
  }

  @Test
  public void test127() throws Exception {
    assertEquals(8, solution.findNthDigit(127));
  }

  @Test
  public void test10() throws Exception {
    assertEquals(1, solution.findNthDigit(10));
  }

  @Test
  public void testFailedOnOverflow() throws Exception {
    assertEquals(1, solution.findNthDigit(1000000000));

  }
}
