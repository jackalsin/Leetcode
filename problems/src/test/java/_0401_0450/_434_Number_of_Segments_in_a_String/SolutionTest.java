package _0401_0450._434_Number_of_Segments_in_a_String;

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
    final String s = "Hello, my name is John";
    assertEquals(5, solution.countSegments(s));
  }

  @Test
  void testOnlineCase2() {
    final String s = " Hello, my name is John";
    assertEquals(5, solution.countSegments(s));
  }
}