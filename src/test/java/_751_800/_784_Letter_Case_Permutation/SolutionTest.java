package _751_800._784_Letter_Case_Permutation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String S = "a1b2";
    final Set<String> expected = Set.of("a1b2", "a1B2", "A1b2", "A1B2");
    assertEquals(expected, new HashSet<>(solution.letterCasePermutation(S)));
  }

  @Test
  void testOnlineCase2() {
    final String S = "3z4";
    final Set<String> expected = Set.of("3z4", "3Z4");
    assertEquals(expected, new HashSet<>(solution.letterCasePermutation(S)));
  }

  @Test
  void testOnlineCase3() {
    final String S = "12345";
    final Set<String> expected = Set.of("12345");
    assertEquals(expected, new HashSet<>(solution.letterCasePermutation(S)));
  }
}