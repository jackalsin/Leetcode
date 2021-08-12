package uber._346_Moving_Average_from_Data_Stream;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MovingAverageTest {
  private static final double BIAS = 1E-9;

  @Test
  void testOnlineCase() throws Exception {
    MovingAverage m = new MovingAverage(3);
    assertEquals(1, m.next(1), BIAS);
    assertEquals((1d + 10d) / 2d, m.next(10), BIAS);
    assertEquals(14d / 3d, m.next(3), BIAS);
    assertEquals(6, m.next(5), BIAS);
  }
}