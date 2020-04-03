package _0701_0750._731_My_Calendar_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertTrue(solution.book(10, 20)); // returns true
    assertTrue(solution.book(50, 60)); // returns true
    assertTrue(solution.book(10, 40)); // returns true
    assertFalse(solution.book(5, 15)); // returns false
    assertTrue(solution.book(5, 10)); // returns true
    assertTrue(solution.book(25, 55)); // returns true

  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
//["book",  "book",   "book","book",  "book","book",  "book","book","book","book"]
//[[24,40], [43,50],  [27,43],[5,21], [30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
//[true,    true,     true,true,      false,false,    true,false,   false,false]
    assertTrue(solution.book(24, 40));
    assertTrue(solution.book(43, 50));
    assertTrue(solution.book(27, 43));
    assertTrue(solution.book(5, 21));
    assertFalse(solution.book(30, 40));
    assertFalse(solution.book(14, 29));
    assertTrue(solution.book(3, 19));
    assertFalse(solution.book(3, 14));
    assertFalse(solution.book(25, 39));
    assertFalse(solution.book(6, 19));
  }

  private static final int[][] INPUT = {
      {47, 50}, {1, 10}, {27, 36}, {40, 47}, {20, 27}, {15, 23}, {10, 18}, {27, 36}, {17, 25}, {8, 17}, {24, 33},
      {23, 28}, {21, 27}, {47, 50}, {14, 21}, {26, 32}, {16, 21}, {2, 7}, {24, 33}, {6, 13}, {44, 50}, {33, 39},
      {30, 36}, {6, 15}, {21, 27},
      {49, 50}, {38, 45}, {4, 12}, {46, 50}, {13, 21}
  };
  private static final boolean[] EXPECTED = {
      true, true, true, true, true, true, true, true, false, false, false, false, false, true, false, false, false,
      true, false, false, false, false, false, false, false, false, true, false, false, false
  };

//  @ParameterizedTest
//  @MethodSource("solutionProvider")
//  void testOnlineCase3(Solution solution){
//    for (int i = 0; i < INPUT.length; i++) {
//      final String functionName = EXPECTED[i] ? "assertTrue" : "assertFalse";
//      System.out.println(functionName + "(solution.book(" + INPUT[i][0] + ", " + INPUT[i][1] + "));");
//    }
//  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    assertTrue(solution.book(47, 50));
    assertTrue(solution.book(1, 10));
    assertTrue(solution.book(27, 36));
    assertTrue(solution.book(40, 47));
    assertTrue(solution.book(20, 27));
    assertTrue(solution.book(15, 23));
    assertTrue(solution.book(10, 18));
    assertTrue(solution.book(27, 36));
    assertFalse(solution.book(17, 25));
    assertFalse(solution.book(8, 17));
    assertFalse(solution.book(24, 33));
    assertFalse(solution.book(23, 28));
    assertFalse(solution.book(21, 27));
    assertTrue(solution.book(47, 50));
    assertFalse(solution.book(14, 21));
    assertFalse(solution.book(26, 32));
    assertFalse(solution.book(16, 21));
    assertTrue(solution.book(2, 7));
    assertFalse(solution.book(24, 33));
    assertFalse(solution.book(6, 13));
    assertFalse(solution.book(44, 50));
    assertFalse(solution.book(33, 39));
    assertFalse(solution.book(30, 36));
    assertFalse(solution.book(6, 15));
    assertFalse(solution.book(21, 27));
    assertFalse(solution.book(49, 50));
    assertTrue(solution.book(38, 45));
    assertFalse(solution.book(4, 12));
    assertFalse(solution.book(46, 50));
    assertFalse(solution.book(13, 21));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(new SolutionI(),
        new BetterSolution());
  }
}