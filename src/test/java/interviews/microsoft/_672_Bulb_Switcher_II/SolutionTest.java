package interviews.microsoft._672_Bulb_Switcher_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  /**
   * Consider the duplication choose. 1 + 1 + 1
   */
  @Test
  void test3And3() {
    assertEquals(8, solution.flipLights(3, 3));
  }

  @Test
  void test1And1() {
    assertEquals(2, solution.flipLights(1, 1));
  }

  @Test
  void test2And1() {
    assertEquals(3, solution.flipLights(2, 1));
  }

  @Test
  void test3And1() {
    assertEquals(4, solution.flipLights(3, 1));
  }

  @Test
  void test3And2() {
    assertEquals(7, solution.flipLights(3, 2));
  }

  @Test
  void test3And4() {
    assertEquals(8, solution.flipLights(3, 4));
  }
}