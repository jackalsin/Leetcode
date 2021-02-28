package apple._722_Remove_Comments;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/27/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration " +
        "", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;",
        "}"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] source = new String[]{"a/*comment", "line", "more_comment*/b"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("ab");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseCharWithComments(Solution solution) {
    final String[] source = new String[]{"a/*comment", "line", "more_comment*/"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("a");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] source = new String[]{"main() {", "/* here is commments", "  // still comments */",
        "   double s = 33;", "   cout << s;", "}"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("main() {", "   double s = 33;", "   cout << s;", "}");
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailed1(Solution solution) {
    final String[] source = new String[]{
        "class test{",
        "public: ",
        "   int x = 1;",
        "   /*double y = 1;*/",
        "   char c;",
        "};"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of(
        "class test{",
        "public: ",
        "   int x = 1;",
        "   ",
        "   char c;",
        "};"
    );
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}