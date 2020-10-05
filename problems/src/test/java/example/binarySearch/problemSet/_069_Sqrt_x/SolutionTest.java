package example.binarySearch.problemSet._069_Sqrt_x;

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
    assertEquals(2, solution.mySqrt(4));
  }

  @Test
  void testOnlineCase2() {
    assertEquals(2, solution.mySqrt(8));
  }

  @Test
  void test1() {
    assertEquals(1, solution.mySqrt(1));
  }

  @Test
  void test5() {
    assertEquals(2, solution.mySqrt(5));
  }
}
