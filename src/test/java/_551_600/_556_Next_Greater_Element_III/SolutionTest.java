package _551_600._556_Next_Greater_Element_III;

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
    assertEquals(21, solution.nextGreaterElement(12));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(-1, solution.nextGreaterElement(21));
  }

  @Test
  void testFailedCase1() {
    assertEquals(230412, solution.nextGreaterElement(230241));
  }

  @Test
  void testFailedCase2() {
    assertEquals(2000001, solution.nextGreaterElement(1200000));
  }
}