package airbnb._224_Basic_Calculator;

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
  void test1Plus1() throws Exception {
    assertEquals(2, solution.calculate("1 + 1"));
  }

  @Test
  void test2Minus1Plus2() throws Exception {
    assertEquals(3, solution.calculate(" 2-1 + 2"));
  }

  @Test
  void testLine3() throws Exception {
    assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  @Test
  void test2147483647() throws Exception {
    assertEquals(2147483647, solution.calculate("2147483647"));
  }

  @Test
  void test1Minus5() throws Exception {
    assertEquals(-4, solution.calculate("1-(5)"));
  }

  @Test
  void testFailedCase1() throws Exception {
    assertEquals(-15, solution.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
  }
}