package _0601_0650._611_Valid_Triangle_Number;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {2, 2, 3, 4};
    assertEquals(3, solution.triangleNumber(input));
  }

  @Test
  void testDuplicate1() {
    // {2, 2, 2}  // {0, 1, 2}
    // {2, 2, 3}  // {0, 1, 3}
    // {2, 2, 3}  // {0, 2, 3}
    // {2, 3, 4}  // {0, 3, 4}
    // {2, 2, 3}  // {1, 2, 3}
    // {2, 3, 4}  // {1, 3, 4}
    // {2, 3, 4}  // {2, 3, 4}
    final int[] input = {2, 2, 2, 3, 4};
    assertEquals(7, solution.triangleNumber(input));
  }
}