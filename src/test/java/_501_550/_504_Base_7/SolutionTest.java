package _501_550._504_Base_7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals("202", solution.convertToBase7(100));
  }

  @Test
  void testOnlineCase2() {
    assertEquals("-10", solution.convertToBase7(-7));
  }

}