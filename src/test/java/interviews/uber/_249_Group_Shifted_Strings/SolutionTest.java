package interviews.uber._249_Group_Shifted_Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() {
    final String[] input = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    final List<List<String>> expected = new ArrayList<>();
    expected.add(Arrays.asList("abc", "bcd", "xyz"));
    expected.add(Arrays.asList("az", "ba"));
    expected.add(Arrays.asList("acef"));
    expected.add(Arrays.asList("a", "z"));
    final List<List<String>> actual = solution.groupStrings(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}