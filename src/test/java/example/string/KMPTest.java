package example.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class KMPTest {

  static Stream<KMP> solutionStream() {
    return Stream.of(
        new KMPI(),
        new KMPII()
    );
  }

  // ----- test of substring -------------------
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSubstring1(KMP solution) {
    final String haystack = "hello", needle = "ll";
    assertEquals(2, solution.substring(haystack, needle));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testSubstring2(KMP solution) {
    final String haystack = "aaaaa", needle = "bba";
    assertEquals(-1, solution.substring(haystack, needle));
  }

  // ----- getNext(final String pattern) --------
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testGetNext1(KMP solution) {
    final String p = "ABCDABD";
    final int[] expected = {-1, 0, 0, 0, 0, 1, 2};
    final int[] actual = solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testGetNext2(KMP solution) {
    final String p = "ABCDABCDABD";
    final int[] expected = {-1, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6};
    final int[] actual = solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testGetNext3(KMP solution) {
    final String p = "";
    final int[] expected = {};
    final int[] actual = solution.getNext(p);
//    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }
}