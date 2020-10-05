package dynamicProgramming.tutorials.introductionToAlgorithms._15_2_Matrix_chain_multiplication.example;

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
  void testTextBookExample1() {
    final int[] p = {30, 35, 15, 5, 10, 20, 25};
    assertEquals(15125, solution.minMultiplication(p));
  }

  @Test
  void testTextBookExample2() {
    final int[] p = {10, 100, 5, 50};
    assertEquals(7500, solution.minMultiplication(p));
  }

  @Test
  void testTextBookExample3() {
    final int[] p = {40, 20, 30, 10, 30};
    assertEquals(26000, solution.minMultiplication(p));
  }

  @Test
  void testTextBookExample4() {
    final int[] p = {10, 20, 30, 40, 30};
    assertEquals(30000, solution.minMultiplication(p));
  }

  @Test
  void testTextBookExample5() {
    final int[] p = {10, 20, 30};
    assertEquals(6000, solution.minMultiplication(p));
  }
}