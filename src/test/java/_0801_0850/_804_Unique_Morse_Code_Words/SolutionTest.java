package _0801_0850._804_Unique_Morse_Code_Words;

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
    final String[] words = {
        "gin", "zen", "gig", "msg"
    };

    assertEquals(2, solution.uniqueMorseRepresentations(words));
  }
}