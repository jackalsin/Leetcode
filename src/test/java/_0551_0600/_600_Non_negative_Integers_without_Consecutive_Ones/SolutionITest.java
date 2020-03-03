package _0551_0600._600_Non_negative_Integers_without_Consecutive_Ones;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 3/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
        list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
        expected = {"Shogun"};
    assertArrayEquals(expected, solution.findRestaurant(list1, list2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"},
        list2 = {"KFC", "Shogun", "Burger King"},
        expected = {"Shogun"};
    assertArrayEquals(expected, solution.findRestaurant(list1, list2));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}