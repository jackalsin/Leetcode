package _901_950._933_Number_of_Recent_Calls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecentCounterTest {
  private RecentCounter rc;

  @BeforeEach
  void setup() {
    rc = new RecentCounter();
  }

  @Test
  void testOnlineCase1() {
    assertEquals(1, rc.ping(1));
    assertEquals(2, rc.ping(100));
    assertEquals(3, rc.ping(3001));
    assertEquals(3, rc.ping(3002));
  }
}