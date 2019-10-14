package _0551_0600._599_Minimum_Index_Sum_of_Two_Lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] list1 = {
        "Shogun", "Tapioca Express", "Burger King", "KFC"
    }, list2 = {
        "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
    }, actual = solution.findRestaurant(list1, list2),
        expected = {"Shogun"};
    assertArrayEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] list1 = {
        "Shogun", "Tapioca Express", "Burger King", "KFC"
    }, list2 = {
        "KFC", "Shogun", "Burger King"
    }, actual = solution.findRestaurant(list1, list2),
        expected = {"Shogun"};
    assertArrayEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}