package microsoft.noodleEssence._409_Longest_Palindrome;

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
  void testOnlineCase() {
    final String input = "abccccdd";
    assertEquals(7, solution.longestPalindrome(input));
  }
}