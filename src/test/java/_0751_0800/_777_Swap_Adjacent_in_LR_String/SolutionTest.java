package _0751_0800._777_Swap_Adjacent_in_LR_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 3/6/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String start = "RXXLRXRXL", end = "XRLXXRRLX";
    assertTrue(solution.canTransform(start, end));
  }

  @Test
  void testFailedCase() {
    final String start = "XXRXXLXXXX",
        end = "XXXXRXXLXX";
    assertFalse(solution.canTransform(start, end));
  }
}
