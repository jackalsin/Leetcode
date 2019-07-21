package interviews.linkedin._380_Insert_Delete_GetRandom_O_1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomizedSetTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(RandomizedSet randomizedSet) throws Exception {
//  ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
//  [[],            [1],        [2],    [2],      [],       [1],      [2],        []]
    randomizedSet.insert(1);
    assertFalse(randomizedSet.remove(2));
    randomizedSet.insert(2);
    randomizedSet.getRandom();
    assertTrue(randomizedSet.remove(1));
    randomizedSet.insert(2);
    randomizedSet.getRandom();
  }

  /**
   * Didn't update the locations map after removing
   *
   * @throws Exception
   */
  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(RandomizedSet randomizedSet) {
//    ["RandomizedSet","insert","insert","remove","insert","insert","insert","remove","remove","insert","remove",
//    "insert","insert","insert","insert","insert","getRandom","insert","remove","insert","insert"]
//[[],                  [3],    [-2],     [2],      [1],      [-3],   [-2],     [-2],   [  3],    [-1],     [-3],
// [1],      [-2],     [-2],   [ -2],   [1],     [],         [-2],   [0],      [-3],[1]]

    assertTrue(randomizedSet.insert(3));
    assertTrue(randomizedSet.insert(-2));
    assertFalse(randomizedSet.remove(2));
    assertTrue(randomizedSet.insert(1));
    assertTrue(randomizedSet.insert(-3));
    assertFalse(randomizedSet.insert(-2));
    assertTrue(randomizedSet.remove(-2));
    assertTrue(randomizedSet.remove(3));

    assertTrue(randomizedSet.insert(-1));
    assertTrue(randomizedSet.remove(-3));

    assertFalse(randomizedSet.insert(1));
    assertTrue(randomizedSet.insert(-2));
    assertFalse(randomizedSet.insert(-2));
    assertFalse(randomizedSet.insert(-2));

    assertFalse(randomizedSet.insert(1));
    assertFalse(randomizedSet.insert(-2));

    assertFalse(randomizedSet.remove(0));
    assertTrue(randomizedSet.insert(-3));
    assertFalse(randomizedSet.insert(1));
  }

  static Stream<RandomizedSet> solutionProvider() {
    return Stream.of(
        new RandomizedSetI(),
        new RandomizedSetII()
    );
  }

}