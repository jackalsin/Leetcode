package _451_500._491_Increasing_Subsequences;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }


  @Test
  void testOnlineCase1() {
    final int[] input = {4, 6, 7, 7};
    final Set<List<Integer>> expected = Set.of(List.of(4, 6), List.of(4, 7), List.of(4, 6, 7), List.of(4, 6, 7, 7),
        List.of(6, 7), List.of(6, 7, 7), List.of(7, 7), List.of(4, 7, 7));
    final List<List<Integer>> actual = solution.findSubsequences(input);
  }
}