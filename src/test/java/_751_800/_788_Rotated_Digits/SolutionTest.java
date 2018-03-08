package _751_800._788_Rotated_Digits;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new NLogNSolution();
    solution = new NSolution();
  }

  @Test
  void testOnlineCaseIn10() {
    assertEquals(0, solution.rotatedDigits(1));
    assertEquals(1, solution.rotatedDigits(2));
    assertEquals(1, solution.rotatedDigits(3));
    assertEquals(1, solution.rotatedDigits(4));
    assertEquals(2, solution.rotatedDigits(5));
    assertEquals(3, solution.rotatedDigits(6));
    assertEquals(3, solution.rotatedDigits(7));
    assertEquals(3, solution.rotatedDigits(8));
    assertEquals(4, solution.rotatedDigits(9));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(316, solution.rotatedDigits(1000));
  }
}
