package _0751_0800._790_Domino_and_Tromino_Tiling;

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
  void test1() {
    assertEquals(1, solution.numTilings(1));
  }
  @Test
  void test2() {
    assertEquals(2, solution.numTilings(2));
  }

  @Test
  void test3() {
    assertEquals(5, solution.numTilings(3));
  }
  @Test
  void test4() {
    assertEquals(11, solution.numTilings(4));
  }
  @Test
  void test5() {
    assertEquals(24, solution.numTilings(5));
  }
  @Test
  void test6() {
    assertEquals(53, solution.numTilings(6));
  }
}