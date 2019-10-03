package interviews.linkedin._068_Text_Justification;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final List<String> expected = List.of("Science  is  what we", "understand      well", "enough to explain to", "a " +
        " computer.  Art is", "everything  else  we", "do                  ");
    final String[] input = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a"
        , "computer.", "Art", "is", "everything", "else", "we", "do"};
    final List<String> actual = solution.fullJustify(input, 20);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithMissed(Solution solution) {
    String[] words = new String[]{"a", "b", "c", "d", "e"};
    List<String> output = new ArrayList<>();
    output.add("a b");
    output.add("c d");
    output.add("e  ");
    assertEquals(output, solution.fullJustify(words, 3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithMissed2(Solution solution) {
    String[] words = new String[]{"What", "must", "be", "shall", "be."};
    List<String> output = new ArrayList<>();
    output.add("What must be");
    output.add("shall be.   ");
    assertEquals(output, solution.fullJustify(words, 12));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithMissed4(Solution solution) {
    String[] words = new String[]{""};
    List<String> output = new ArrayList<>();
    output.add("  ");
    assertEquals(output, solution.fullJustify(words, 2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithMissed3(Solution solution) {
    String[] words = new String[]{"a", "b", "c", "d", "e"};
    List<String> output = new ArrayList<>();
    output.add("a");
    output.add("b");
    output.add("c");
    output.add("d");
    output.add("e");
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithEmptyStringAndZeroLength(Solution solution) {
    String[] words = new String[]{""};
    List<String> output = new ArrayList<>();
    output.add("");
    assertEquals(output, solution.fullJustify(words, 0));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithWordEqualMax(Solution solution) {
    String[] words = new String[]{"a"};
    List<String> expected = new ArrayList<>();
    expected.add("a");
    assertEquals(expected, solution.fullJustify(words, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testWithOnlineCase(Solution solution) {
    String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
    List<String> output = Arrays.asList("This    is    an", "example  of text", "justification.  ");
    assertEquals(output, solution.fullJustify(words, 16));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV()
    );
  }
}