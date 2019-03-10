package interviews.airbnb.hilbertCurve;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(3, solution.hilbertCurve(1, 1, 2));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(2, solution.hilbertCurve(0, 1, 1));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(9, solution.hilbertCurve(2, 2, 2));
  }
}