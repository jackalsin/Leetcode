package _1251_1300._1268_Search_Suggestions_System;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
class SolutionTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] products = {
        "mobile", "mouse", "moneypot", "monitor", "mousepad"
    };
    final String searchWord = "mouse";
    final List<List<String>> expected = List.of(
        List.of("mobile", "moneypot", "monitor"),
        List.of("mobile", "moneypot", "monitor"),
        List.of("mouse", "mousepad"),
        List.of("mouse", "mousepad"),
        List.of("mouse", "mousepad")),
        actual = solution.suggestedProducts(products, searchWord);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] products = {"havana"};
    final String searchWord = "tatiana";
    final List<List<String>> expected = List.of(
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of(),
        List.of()
    ),
        actual = solution.suggestedProducts(products, searchWord);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] products = {"havana"};
    final String searchWord = "havana";
    final List<List<String>> expected = List.of(
        List.of("havana"),
        List.of("havana"),
        List.of("havana"),
        List.of("havana"),
        List.of("havana"),
        List.of("havana")
    ), actual = solution.suggestedProducts(products, searchWord);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String[] products = {
        "bags", "baggage", "banner", "box", "cloths"
    };
    final String searchWord = "bags";
    final List<List<String>> expected = List.of(
        List.of("baggage", "bags", "banner"),
        List.of("baggage", "bags", "banner"),
        List.of("baggage", "bags"),
        List.of("bags")
    ), actual = solution.suggestedProducts(products, searchWord);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new TrieSolution(),
        new BinarySearchSolution()
    );
  }
}