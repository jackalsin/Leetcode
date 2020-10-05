package facebook._161_One_Edit_Distanc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmptyWithEmpty() {
    assertFalse(solution.isOneEditDistance("", ""));
  }

  @Test
  void test1With0() {
    assertTrue(solution.isOneEditDistance("1", ""));
  }

  @Test
  void test2With1() {
    assertTrue(solution.isOneEditDistance("12", "1"));
  }

  @Test
  void test4With4() {
    assertTrue(solution.isOneEditDistance("1234", "1233"));
  }
}