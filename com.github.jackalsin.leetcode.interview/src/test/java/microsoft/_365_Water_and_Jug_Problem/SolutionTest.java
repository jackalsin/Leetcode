package microsoft._365_Water_and_Jug_Problem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    assertTrue(solution.canMeasureWater(3, 5, 4));
  }

  @Test
  void testOnlineCase2() throws Exception {
    assertFalse(solution.canMeasureWater(2, 6, 5));
  }

  @Test
  void testFailedCase1() throws Exception {
    assertTrue(solution.canMeasureWater(0, 0, 0));
  }

  @Test
  void testFailedCase2() throws Exception {
    assertFalse(solution.canMeasureWater(0, 0, 1));
  }

  @Test
  void testFailedOnGcd() throws Exception {
    assertTrue(solution.canMeasureWater(1, 2, 3));
  }

}