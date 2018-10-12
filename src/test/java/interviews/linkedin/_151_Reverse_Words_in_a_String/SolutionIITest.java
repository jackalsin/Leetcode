package interviews.linkedin._151_Reverse_Words_in_a_String;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testOnline() {
    String input = "the sky is blue";
    String expected = "blue is sky the";
    assertEquals(expected, solution.reverseWords(input));
  }

  @Test
  void testSpace() {
    String input = " ";
    String expected = "";
    assertEquals(expected, solution.reverseWords(input));
  }

  @Test
  void testFailed() {
    String input = " 1";
    String expected = "1";
    assertEquals(expected, solution.reverseWords(input));
  }

  @Test
  void testFailed2() {
    String input = "1 ";
    String expected = "1";
    assertEquals(expected, solution.reverseWords(input));
  }
}