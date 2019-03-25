package _1001_1050._1023_Binary_String_With_Substrings_Representing_1_To_N;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertTrue(solution.queryString("0110", 3));
  }

  @Test
  void testOnlineCase2() {
    assertFalse(solution.queryString("0110", 4));
  }


}