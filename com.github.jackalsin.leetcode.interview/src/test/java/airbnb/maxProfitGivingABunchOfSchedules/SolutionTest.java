package airbnb.maxProfitGivingABunchOfSchedules;

import definition.Interval;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/21/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final Interval[] intervals = {
        new Interval(0, 10),
        new Interval(5, 15),
        new Interval(10, 20),
        new Interval(15, 30),
    };
    assertEquals(25, solution.maxProfit(intervals));
  }
}