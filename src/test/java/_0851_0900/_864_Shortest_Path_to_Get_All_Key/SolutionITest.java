package _0851_0900._864_Shortest_Path_to_Get_All_Key;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BfsSolution();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = {
        "@.a.#",
        "###.#",
        "b.A.B"
    };
    assertEquals(8, solution.shortestPathAllKeys(input));
  }

  @Test
  void testOnlineCase2() {
    final String[] input = {
        "@..aA",
        "..B#.",
        "....b"
    };
    assertEquals(6, solution.shortestPathAllKeys(input));
  }
}