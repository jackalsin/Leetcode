package _0901_0950._904_Fruit_Into_Baskets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OnePassSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new OnePassSolution();
  }

  @Test
  void testOnlineCase1() {
    final int input[] = {1, 2, 1}, expected = 3;
    assertEquals(expected, solution.totalFruit(input));
  }

  @Test
  void testOnlineCase2() {
    final int input[] = {0, 1, 2, 2}, expected = 3;
    assertEquals(expected, solution.totalFruit(input));
  }

  @Test
  void testOnlineCase3() {
    final int input[] = {1, 2, 3, 2, 2}, output = 4;
    assertEquals(output, solution.totalFruit(input));
  }

  @Test
  void testOnlineCase4() {
    final int input[] = {3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}, output = 5;
    assertEquals(output, solution.totalFruit(input));
  }

}