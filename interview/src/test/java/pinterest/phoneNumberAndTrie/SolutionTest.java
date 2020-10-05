package pinterest.phoneNumberAndTrie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final List<String> words = List.of("word", "abc", "mhi", "mhij");
    final Set<String> expected = Set.of("mhi");
    final String phoneNum = "644";
    final List<String> actual = solution.search(words, phoneNum);
    assertEquals(expected, new HashSet<>(actual));
  }
}