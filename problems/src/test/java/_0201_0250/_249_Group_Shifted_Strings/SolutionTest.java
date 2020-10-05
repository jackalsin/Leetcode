package _0201_0250._249_Group_Shifted_Strings;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/23/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
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
