package interviews.linkedin._127_Word_Ladder;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/20/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFailedOnNonExistence() throws Exception {
    final List<String> wordList = List.of("hot", "dot", "dog", "lot", "log");
    final String begin = "hit";
    final String end = "cog";
    assertEquals(0, solution.ladderLength(begin, end, wordList));
  }

  @Test
  public void testFailedCount() throws Exception {
    final List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
    final String begin = "hit";
    final String end = "cog";
    assertEquals(5, solution.ladderLength(begin, end, wordList));
  }

  @Test
  public void testBeginWordCount() throws Exception {
    final List<String> wordList = List.of("a", "b", "c");
    final String begin = "a";
    final String end = "c";
    assertEquals(2, solution.ladderLength(begin, end, wordList));
  }

}
