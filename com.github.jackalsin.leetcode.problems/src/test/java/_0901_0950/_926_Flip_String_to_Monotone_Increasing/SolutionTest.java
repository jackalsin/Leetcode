package _0901_0950._926_Flip_String_to_Monotone_Increasing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(1, solution.minFlipsMonoIncr("00110"));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(2, solution.minFlipsMonoIncr("010110"));
  }

  @Test
  void testOnlineCase3() {
    assertEquals(2, solution.minFlipsMonoIncr("00011000"));
  }
}