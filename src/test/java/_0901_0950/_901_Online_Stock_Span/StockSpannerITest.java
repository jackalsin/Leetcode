package _0901_0950._901_Online_Stock_Span;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/19/2020
 */
class StockSpannerITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(StockSpanner solution) {
    assertEquals(1, solution.next(100));
    assertEquals(1, solution.next(80));
    assertEquals(1, solution.next(60));
    assertEquals(2, solution.next(70));
    assertEquals(1, solution.next(60));
    assertEquals(4, solution.next(75));
    assertEquals(6, solution.next(85));
  }

  static Stream<StockSpanner> solutionStream() {
    return Stream.of(
        new StockSpannerI()
    );
  }
}