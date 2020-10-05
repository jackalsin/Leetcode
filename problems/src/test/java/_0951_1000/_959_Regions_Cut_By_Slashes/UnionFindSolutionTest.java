package _0951_1000._959_Regions_Cut_By_Slashes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnionFindSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new UnionFindSolution();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = {
        " /",
        "/ "
    };
    assertEquals(2, solution.regionsBySlashes(input));
  }

  @Test
  void testOnlineCase2() {
    final String[] input = {
        " /",
        "  "
    };
    assertEquals(1, solution.regionsBySlashes(input));
  }

  @Test
  void testOnlineCase3() {
    final String[] input = {
        "\\/",
        "/\\"
    };
    assertEquals(4, solution.regionsBySlashes(input));
  }

  @Test
  void testOnlineCase4() {
    final String[] input = {
        "/\\",
        "\\/"
    };
    assertEquals(5, solution.regionsBySlashes(input));
  }

  @Test
  void testOnlineCase5() {
    final String[] input = {
        "//",
        "/ "
    };
    assertEquals(3, solution.regionsBySlashes(input));
  }
}