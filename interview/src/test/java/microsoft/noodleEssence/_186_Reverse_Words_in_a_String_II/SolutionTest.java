package microsoft.noodleEssence._186_Reverse_Words_in_a_String_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnline() throws Exception {
    char[] input = "the sky is blue".toCharArray();
    char[] expected = "blue is sky the".toCharArray();
    solution.reverseWords(input);
    assertArrayEquals(expected, input);
  }
}