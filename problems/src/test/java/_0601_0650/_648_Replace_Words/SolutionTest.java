package _0601_0650._648_Replace_Words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/5/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final List<String> dict = List.of("cat", "bat", "rat");
    final String sentence = "the cattle was rattled by the battery", expeted = "the cat was rat " +
        "by the bat";
    final String actual = solution.replaceWords(dict, sentence);
    assertEquals(expeted, actual);
  }
}
