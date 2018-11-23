package _0351_0400._371_Sum_of_Two_Integers;

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
  void test1Plus1() {
    assertEquals(4, solution.getSum(2, 2));
  }
}