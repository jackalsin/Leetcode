package interviews.google._731_My_Calendar_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertTrue(solution.book(10, 20)); // returns true
    assertTrue(solution.book(50, 60)); // returns true
    assertTrue(solution.book(10, 40)); // returns true
    assertFalse(solution.book(5, 15)); // returns false
    assertTrue(solution.book(5, 10)); // returns true
    assertTrue(solution.book(25, 55)); // returns true
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
//["book",  "book",   "book","book",  "book","book",  "book","book","book","book"]
//[[24,40], [43,50],  [27,43],[5,21], [30,40],[14,29],[3,19],[3,14],[25,39],[6,19]]
//[true,    true,     true,true,      false,false,    true,false,   false,false]
    assertTrue(solution.book(24, 40)); // [24, 39]
    assertTrue(solution.book(43, 50)); // [24, 39] [43, 49]
    assertTrue(solution.book(27, 43)); // [24, 26, 1], [27, 39, 2], [40, 49, 1]
    assertTrue(solution.book(5, 21)); // [5, 21, 1], [24, 26, 1], [27, 39, 2], [40, 49, 1]
    assertFalse(solution.book(30, 40));
    assertFalse(solution.book(14, 29));
    assertTrue(solution.book(3, 19));
    assertFalse(solution.book(3, 14));
    assertFalse(solution.book(25, 39));
    assertFalse(solution.book(6, 19));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
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


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
//    ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book","book","book","book",
//    "book","book","book","book","book","book","book"]
//[[],[26,45],[76,92],[25,37],[18,36],[40,50],[19,31],[48,60],[1,16],[46,65],[61,78],[74,90],[43,60],[27,43],[5,21],
//[null,true, true,   true,     false,  true,   false,  true,   true, false,  true,   false,  false,  false,  true,
// [80,90],[14,29],[3,19],[3,14],[75,89],[56,69]]
// true,    false,  false,  false,  false,  true]
    assertTrue(solution.book(26, 45));
    assertTrue(solution.book(76, 92));
    assertTrue(solution.book(25, 37));
    assertFalse(solution.book(18, 36));
    assertTrue(solution.book(40, 50));
    assertFalse(solution.book(19, 31));
    assertTrue(solution.book(48, 60));
    assertTrue(solution.book(1, 16));
    assertFalse(solution.book(46, 65));
    assertTrue(solution.book(61, 78));
    assertFalse(solution.book(74, 90));
    assertFalse(solution.book(43, 60));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}