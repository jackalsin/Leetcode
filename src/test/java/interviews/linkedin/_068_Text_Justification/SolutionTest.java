package interviews.linkedin._068_Text_Justification;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  public void testOnline() throws Exception {
    final String[] input = {"This", "is", "an", "example", "of", "text", "justification."};
    final List<String> expected = List.of("This    is    an", "example  of text", "justification." +
        "  ");
    assertEquals(expected, solution.fullJustify(input, 16));
  }

  @Test
  public void testFailedOnEmpty() throws Exception {
    final String[] input = {""};
    final List<String> expected = List.of("");
    assertEquals(expected, solution.fullJustify(input, 0));
  }

  @Test
  public void testFailedSingleWordPerLine() throws Exception {
    final String[] input = {"a", "b", "c", "d", "e"};
    final List<String> expected = List.of("a", "b", "c", "d", "e");
    assertEquals(expected, solution.fullJustify(input, 1));
  }

  @Test
  public void testFailed3() throws Exception {
    final String[] input = {"Here", "is", "an", "example", "of", "text", "justification."};
    final List<String> expected = List.of("Here    is   an", "example of text", "justification. ");
    assertEquals(expected, solution.fullJustify(input, 15));
  }
}
