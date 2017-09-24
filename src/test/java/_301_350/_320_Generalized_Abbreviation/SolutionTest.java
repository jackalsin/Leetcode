package _301_350._320_Generalized_Abbreviation;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/23/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWord() throws Exception {
    final String word = "word";
    final List<String> expected = Arrays.asList("word", "1ord", "w1rd", "wo1d", "wor1", "2rd",
        "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4");
    final List<String> result = solution.generateAbbreviations(word);
    assertEquals(new HashSet<>(expected), new HashSet<>(result));
  }

  @Test
  public void testEmpty() throws Exception {
    final String word = "";
    final List<String> result = Collections.singletonList("");
    assertEquals(result, solution.generateAbbreviations(word));
  }
}
