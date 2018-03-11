package _751_800._792_Number_of_Matching_Subsequences;

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
    final String S = "abcde";
    final String[] words = {"a", "bb", "acd", "ace"};
    assertEquals(3, solution.numMatchingSubseq(S, words));
  }
}
