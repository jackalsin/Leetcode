package example.binarySearch.problemSet._374_Guess_Number_Higher_or_Lower;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @BeforeEach
  void setUp() throws Exception {}

  @Test
  void testOnlineCase() throws Exception {
    final int pick = 6;
    final Solution solution = new Solution(pick);
    assertEquals(6, solution.guessNumber(10));
  }

  @Test
  void testGuess() throws Exception {
    final Solution solution = new Solution(6);

    assertEquals(-1, solution.guess(10));
    assertEquals(0, solution.guess(6));
    assertEquals(1, solution.guess(3));
  }
}
