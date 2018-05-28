package interviews.pinterest.thumbUp;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  @Test
  void testOnlineCase1() {
    final String[][] input = {
        {"url1", "userA", "1"},
        {"url1", "userB", "2"},
        {"url2", "userA", "3"},
        {"url3", "userC", "4"}
    };
    final Solution solution = new Solution(input);
    final Map<String, Long> expected = Map.of("url1", 1L, "url2", 3L, "url3", 4L),
        actual = solution.getEarliest();
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String[][] input = {
        {"url1", "userA", "1"},
        {"url1", "userB", "2"},
        {"url2", "userA", "3"},
        {"url2", "userB", "4"},
        {"url3", "userC", "5"}
    };
    final Solution solution = new Solution(input);
    assertEquals("userB", solution.getSimilarUser("userA"));
  }
}