package dynamicProgramming.tutorials.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BottomUpSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new BottomUpSolution();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(1, solution.fib(1));
    assertEquals(1, solution.fib(2));
    assertEquals(2, solution.fib(3));
    assertEquals(3, solution.fib(4));
    assertEquals(5, solution.fib(5));
    assertEquals(8, solution.fib(6));
  }

}