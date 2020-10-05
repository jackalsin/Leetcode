package uber.accessLimit100;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author jacka
 * @version 1.0 on 3/12/2018.
 */
class RateLimitTest {
  private RateLimit solution;

  @BeforeEach
  void setup() {
    solution = new RateLimit();
  }

  @Test
  void testOnlineCase1() {
    for (int i = 0; i < 100; i++) {
      assertTrue(solution.isAllowed(1));
    }
  }

}
