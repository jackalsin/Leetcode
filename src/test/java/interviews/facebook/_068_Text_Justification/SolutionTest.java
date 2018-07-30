package interviews.facebook._068_Text_Justification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithMissed() {
    String[] words = new String[]{"a", "b", "c", "d", "e"};
    List<String> output = new ArrayList<>();
    output.add("a b");
    output.add("c d");
    output.add("e  ");
    assertEquals(output, solution.fullJustify(words, 3));
  }

  @Test
  void testWithMissed2() {
    String[] words = new String[]{"What", "must", "be", "shall", "be."};
    List<String> output = new ArrayList<>();
    output.add("What must be");
    output.add("shall be.   ");
    assertEquals(output, solution.fullJustify(words, 12));
  }

  @Test
  void testWithMissed4() {
    String[] words = new String[]{""};
    List<String> output = new ArrayList<>();
    output.add("  ");
    assertEquals(output, solution.fullJustify(words, 2));
  }

  @Test
  void testWithMissed3() {
    String[] words = new String[]{"a", "b", "c", "d", "e"};
    List<String> output = new ArrayList<>();
    output.add("a");
    output.add("b");
    output.add("c");
    output.add("d");
    output.add("e");
  }

  @Test
  void testWithEmptyStringAndZeroLength() {
    String[] words = new String[]{""};
    List<String> output = new ArrayList<>();
    output.add("");
    assertEquals(output, solution.fullJustify(words, 0));
  }

  @Test
  void testWithWordEqualMax() {
    String[] words = new String[]{"a"};
    List<String> expected = new ArrayList<>();
    expected.add("a");
    assertEquals(expected, solution.fullJustify(words, 1));
  }

  @Test
  void testWithOnlineCase() {
    String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    List<String> output = Arrays.asList("This    is    an", "example  of text", "justification.  ");
    assertEquals(output, solution.fullJustify(words, 16));
  }

  @Test
  void testWithPaddingOneWord() {
    final String input = "justification.";
    final List<String> curLine = new ArrayList<>();
    curLine.add("justification.");
    assertEquals("justification.  ",
        solution.paddingToWidth(16, curLine));
  }

  @Test
  void testWithActualLenLine2() {
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
  void testWithActualLenLine1() {
    final String expected = "This    is    an";
    final String input = "This is an";
    final List<String> curLine = new ArrayList<>();
    curLine.add("This");
    curLine.add("is");
    curLine.add("an");
    assertEquals(expected,
        solution.paddingToWidth(16, curLine));
  }

  @Test
  void testWithLastLine() {
    final List<String> input = List.of("abc", "def");
    final String expected = "abc def    ";
    assertEquals(expected, solution.paddingToWidthLast(expected.length(), input));
  }
}