package interviews.uber._648_Replace_Words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<String> dict = List.of("cat", "bat", "rat");
    final String sentence = "the cattle was rattled by the battery", expeted = "the cat was rat " +
        "by the bat";
    final String actual = solution.replaceWords(dict, sentence);
    assertEquals(expeted, actual);
  }
}