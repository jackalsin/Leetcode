package interviews.microsoft._722_Remove_Comments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[] source = new String[]{"/*Test program */", "int main()", "{ ", "  // variable declaration " +
        "", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("int main()", "{ ", "  ", "int a, b, c;", "a = b + c;", "}");
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String[] source = new String[]{"a/*comment", "line", "more_comment*/b"};
    final List<String> actual = solution.removeComments(source);
    final List<String> expected = List.of("ab");
    assertEquals(expected, actual);
  }

}