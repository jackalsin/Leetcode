package _051_100._068_Text_Justification;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/3/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }
//
//  @Test
//  public void testWithMissed() throws Exception {
//    String[] words = new String[] {"a","b","c","d","e"};
//    List<String> output = new ArrayList<>();
//    output.add("a b");
//    output.add("c d");
//    output.add("e  ");
//    assertEquals(output, solution.fullJustify(words, 3));
//  }

  @Test
  public void testWithMissed2() throws Exception {
    String[] words = new String[] {"a","b","c","d","e"};
    List<String> output = new ArrayList<>();
    output.add("a");
    output.add("b");
    output.add("c");
    output.add("d");
    output.add("e");
    assertEquals(output, solution.fullJustify(words, 1));
  }

  @Test
  public void testWithEmptyStringAndZeroLength() throws Exception {
    String[] words = new String[] {""};
    List<String> output = new ArrayList<>();
    output.add("");
    assertEquals(output, solution.fullJustify(words, 0));
  }

  @Test
  public void testWithWordEqualMax() throws Exception {
    String[] words = new String[] {"a"};
    List<String> expected = new ArrayList<>();
    expected.add("a");
    assertEquals(expected, solution.fullJustify(words, 1));
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    List<String> output = Arrays.asList("This    is    an", "example  of text", "justification.  ");
    assertEquals(output, solution.fullJustify(words, 16));
  }

  @Test
  public void testWithPaddingOneWord() throws Exception {
    final String input = "justification.";
    final List<String> curLine = new ArrayList<>();
    curLine.add("justification.");
    assertEquals("justification.  ",
        solution.paddingToWidth(16, curLine));
  }

  @Test
  public void testWithActualLenLine2() throws Exception {
    final String expected = "example  of text";
    final String input = "example of text";
    final List<String> curLine = new ArrayList<>();
    curLine.add("example");
    curLine.add("of");
    curLine.add("text");
    assertEquals(expected,
        solution.paddingToWidth(16, curLine));
  }

  @Test
  public void testWithActualLenLine1() throws Exception {
    final String expected = "This    is    an";
    final String input = "This is an";
    final List<String> curLine = new ArrayList<>();
    curLine.add("This");
    curLine.add("is");
    curLine.add("an");
    assertEquals(expected,
        solution.paddingToWidth(16, curLine));
  }


}
