package _0351_0400._362_Design_Hit_Counter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class HitCounterTest {

  @Test
  public void testOnlineCase1() throws Exception {
    HitCounter counter = new HitCounter();

// hit at timestamp 1.
    counter.hit(1);

// hit at timestamp 2.
    counter.hit(2);

// hit at timestamp 3.
    counter.hit(3);

// get hits at timestamp 4, should return 3.
    assertEquals(3, counter.getHits(4));

// hit at timestamp 300.
    counter.hit(300);

// get hits at timestamp 300, should return 4.
    assertEquals(4, counter.getHits(300));

// get hits at timestamp 301, should return 3.
    assertEquals(3, counter.getHits(301));
  }

}
