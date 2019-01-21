package interviews.airbnb._003_Longest_Substring_Without_Repeating_Characters;

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
  void testOnlineCase1() {
    final String input = "pwwkew";
    assertEquals(3, solution.lengthOfLongestSubstring(input));
  }

}