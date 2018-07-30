package interviews.facebook._069_Sqrt_x;

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
  void test1() {
    assertEquals(1, solution.mySqrt(1));
  }

  @Test
  void test2() {
    assertEquals(1, solution.mySqrt(2));
  }

  @Test
  void test3() {
    assertEquals(1, solution.mySqrt(3));
  }

  @Test
  void test4() {
    assertEquals(2, solution.mySqrt(4));
  }

  @Test
  void test5() {
    assertEquals(2, solution.mySqrt(5));
  }

  @Test
  void test2147395599() {
    assertEquals(46339, solution.mySqrt(2147395599));
  }
}