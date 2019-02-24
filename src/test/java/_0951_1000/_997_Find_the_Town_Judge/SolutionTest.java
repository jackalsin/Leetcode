package _0951_1000._997_Find_the_Town_Judge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int N = 2;
    final int[][] trust = {{
        1, 2
    }};
    assertEquals(2, solution.findJudge(N, trust));

  }

  @Test
  void testOnlineCase2() {
    final int N = 3;
    final int[][] trust = {
        {1, 3}, {2, 3}
    };
    assertEquals(3, solution.findJudge(N, trust));
  }

  @Test
  void testOnlineCase3() {
    final int N = 3;
    final int[][] trust = {
        {1, 3}, {2, 3}, {3, 1}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

  @Test
  void testOnlineCase4() {
    final int N = 3;
    final int[][] trust = {
        {1, 2}, {2, 3}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

  @Test
  void testOnlineCase5() {
    final int N = 4;
    final int[][] trust = {
        {1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}
    };
    assertEquals(3, solution.findJudge(N, trust));
  }

  @Test
  void testOnlineCase6() {
    final int N = 2;
    final int[][] trust = {
        {1, 2}, {2, 1}
    };
    assertEquals(-1, solution.findJudge(N, trust));
  }

}