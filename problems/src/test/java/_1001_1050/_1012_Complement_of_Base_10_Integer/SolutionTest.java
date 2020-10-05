package _1001_1050._1012_Complement_of_Base_10_Integer;

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
    assertEquals(2, solution.bitwiseComplement(5));
  }

  @Test
  void test0() {
    assertEquals(1, solution.bitwiseComplement(0));
  }
}