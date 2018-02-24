package interviews.uber._692_Top_K_Frequent_Words;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapSolutionTest {
  private Solution solution;

  @org.junit.jupiter.api.BeforeEach
  void setUp() {
    solution = new MapSolution();
  }

  @Test
  void testOnlineCase1() {
    final String[] input = {"i", "love", "leetcode", "i", "love", "leetcode"};
    final List<String> expected = List.of("i", "leetcode");
    final List<String> actual = solution.topKFrequent(input, 2);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String[] input = {"i", "love", "leetcode", "i", "love", "coding"};
    final List<String> expected = List.of("i", "love");
    final List<String> actual = solution.topKFrequent(input, 2);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase3() {
    final String[] input = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    final List<String> expected = List.of("the", "is", "sunny", "day");
    final List<String> actual = solution.topKFrequent(input, 4);
    assertEquals(expected, actual);
  }
}