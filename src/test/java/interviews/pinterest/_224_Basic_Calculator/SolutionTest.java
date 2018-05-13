package interviews.pinterest._224_Basic_Calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new RecursionSolution();
    solution = new StackSolution();
  }

  @Test
  void test1Plus1() {
    assertEquals(2, solution.calculate("1 + 1"));
  }

  @Test
  void test2Minus1Plus2() {
    assertEquals(3, solution.calculate(" 2-1 + 2"));
  }

  @Test
  void test2Minus1Plus2WithTrailingSpace() {
    assertEquals(3, solution.calculate(" 2-1 + 2 "));
  }

  @Test
  void testLine3() {
    assertEquals(23, solution.calculate("(1+(4+5+2)-3)+(6+8)"));
  }

  @Test
  void test2147483647() {
    assertEquals(2147483647, solution.calculate("2147483647"));
  }
}