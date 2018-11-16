package _701_750._736_Parse_Lisp_Expression;

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
    final String input = "(add 1 2)";
    assertEquals(3, solution.evaluate(input));

  }

  @Test
  void testOnlineCase2() {
    final String input = "(mult 3 (add 2 3))";
    assertEquals(15, solution.evaluate(input));
  }

  @Test
  void testOnlineCase3() {
    final String input = "(let x 2 (mult x 5))";
    assertEquals(10, solution.evaluate(input));

  }

  @Test
  void testOnlineCase4() {
    final String input = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
    assertEquals(14, solution.evaluate(input));
  }

  @Test
  void testOnlineCase5() {
    final String input = "(let x 3 x 2 x)";
    assertEquals(2, solution.evaluate(input));
  }

  @Test
  void testOnlineCase6() {
    final String input = "(let x 1 y 2 x (add x y) (add x y))";
    assertEquals(5, solution.evaluate(input));

  }

  @Test
  void testOnlineCase7() {
    final String input = "(let x 2 (add (let x 3 (let x 4 x)) x))";
    assertEquals(6, solution.evaluate(input));
  }

  @Test
  void testOnlineCase8() {
    final String input = "(let a1 3 b2 (add a1 1) b2)";
    assertEquals(4, solution.evaluate(input));

  }

  @Test
  void testOnlineCase9() {
    final String input = "(let x -2 y x y)";
    assertEquals(-2, solution.evaluate(input));
  }

}