package interviews.linkedin._123_Best_Time_to_Buy_and_Sell_Stock_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testEmpty() {
    assertEquals(0, solution.maxProfit(new int[]{}));
  }

  @Test
  void test2TransMax() {
    final int[] input = new int[]{1, 5, 0, 1, 5};
    assertEquals(9, solution.maxProfit(input));
  }

  @Test
  void test1TransMax() {
    final int[] input = new int[]{1, 2, 3, 4, 5};
    assertEquals(4, solution.maxProfit(input));
  }

  @Test
  void testMultiMaxLater() {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(input));
  }

  @Test
  void testMultiTransMaxContinous() {
    final int[] input = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
    assertEquals(13, solution.maxProfit(input));
  }

  @Test
  void test3TransMax() {
    final int[] input = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
    assertEquals(6, solution.maxProfit(input));
  }

}