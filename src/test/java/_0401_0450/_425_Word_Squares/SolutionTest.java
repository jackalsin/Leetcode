package _0401_0450._425_Word_Squares;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] words = {"area", "lead", "wall", "lady", "ball"};
    final List<List<String>> expected = List.of(
        List.of(
            "wall",
            "area",
            "lead",
            "lady"),
        List.of(
            "ball",
            "area",
            "lead",
            "lady"
        )
    );
    final List<List<String>> actual = solution.wordSquares(words);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] words = {"abat", "baba", "atan", "atal"};
    final List<List<String>> expected = List.of(
        List.of(
            "baba",
            "abat",
            "baba",
            "atan"
        ),
        List.of(
            "baba",
            "abat",
            "baba",
            "atal"
        )
    );
    final List<List<String>> actual = solution.wordSquares(words);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}