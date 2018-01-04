package _701_750._729_My_Calendar_I;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyCalendarTest {

  @Test
  public void testOnlineCase() throws Exception {
    final MyCalendar calendar = new MyCalendar();
    assertTrue(calendar.book(10, 20)); // returns true
    assertFalse(calendar.book(15, 25)); // returns false
    assertTrue(calendar.book(20, 30)); // returns true
  }

  @Test
  public void testFailedCase1() throws Exception {
    final MyCalendar calendar = new MyCalendar();
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
}