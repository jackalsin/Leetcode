package dropbox.oa.textEditor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/20/2021
 */
class TextEditorImplTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey you"},
        {"1", "BACKSPACE"},
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey yo", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey you"},
        {"1", "BACKSPACE"},
        {"2", "BACKSPACE"},
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey y", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "!"},
        {"1", "BACKSPACE"},
        {"2", "BACKSPACE"},
    };

    final String actual = solution.getOutput(input);
    assertEquals("", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "APPEND", " there"},
        {"2", "APPEND", "!"},
        {"3", "BACKSPACE"},
        {"4", "UNDO"},
        {"5", "UNDO"},
        {"6", "UNDO"}
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4_2(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey"},
        {"4", "UNDO"},
        {"6", "UNDO"}
    };
    final String actual = solution.getOutput(input);
    assertEquals("", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "UNDO"},
        {"2", "UNDO"}
    };
    final String actual = solution.getOutput(input);
    assertEquals("", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "APPEND", " there"},
        {"2", "UNDO"},
        {"3", "REDO"},
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey there", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase8(TextEditor solution) {
    final String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "UNDO"},
        {"2", "REDO"},
        {"3", "REDO"},
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey", actual);
  }

  /**
   * @param solution
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testRedo3(TextEditor solution) {
    String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "UNDO"},
        {"2", "APPEND", " there"},
        {"3", "REDO"},
    };
    String actual = solution.getOutput(input);
    assertEquals(" there", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testChronological(TextEditor solution) {
    String[][] input = {
        {"1548185072722", "APPEND", "ey"},
        {"1548185072721", "APPEND", "H"}
    };
    String actual = solution.getOutput(input);
    assertEquals("Hey", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testSelectBackspace(TextEditor solution) {
    String[][] input = {
        {"1548185072721", "APPEND", "Hello"},
        {"1548185072722", "SELECT", "1", "3"},
        {"1548185072723", "BACKSPACE"}
    };
    String actual = solution.getOutput(input);
    assertEquals("Hlo", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testSelectAppend(TextEditor solution) {
    String[][] input = {
        {"1548185072721", "APPEND", "Hello"},
        {"1548185072722", "SELECT", "2", "5"},
        {"1548185072723", "APPEND", "y there"}
    };
    String actual = solution.getOutput(input);
    assertEquals("Hey there", actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testBold(TextEditor solution) {
    String[][] input = {
        {"1548185072721", "APPEND", "Hello"},
        {"1548185072722", "SELECT", "1", "3"},
        {"1548185072723", "BOLD"}
    };
    final String actual = solution.getOutput(input);
    assertEquals("H*el*lo", actual);
  }
  // ----------------- official --------------

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOfficial1(TextEditor solution) {
    String[][] input = {
        {"0", "APPEND", "Hey"},
        {"1", "APPEND", " there"},
        {"2", "APPEND", "!"},
    };
    final String actual = solution.getOutput(input);
    assertEquals("Hey there!", actual);
  }

  static Stream<TextEditor> solutionStream() {
    return Stream.of(
        new TextEditorImpl()
    );
  }
}