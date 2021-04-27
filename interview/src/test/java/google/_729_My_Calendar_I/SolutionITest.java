package google._729_My_Calendar_I;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/26/2021
 */
class SolutionITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase(MyCalendar calendar) {
    assertTrue(calendar.book(10, 20)); // returns true
    assertFalse(calendar.book(15, 25)); // returns false
    assertTrue(calendar.book(20, 30)); // returns true
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1(MyCalendar calendar) {
    assertTrue(calendar.book(47, 50));
    assertTrue(calendar.book(33, 41));
    assertFalse(calendar.book(39, 45));
    assertFalse(calendar.book(33, 42));
    assertTrue(calendar.book(25, 32));
    assertFalse(calendar.book(26, 35));
    assertTrue(calendar.book(19, 25));
    assertTrue(calendar.book(3, 8));
    assertFalse(calendar.book(18, 27));
  }

  static Stream<MyCalendar> solutionStream() {
    return Stream.of(
        new MyCalendarI()
    );
  }
}