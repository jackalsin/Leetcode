package interviews.linkedin._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/12/2019
 */
class RandomizedCollectionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase1(RandomizedCollection randomizedCollection) {
//    ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
//    [[],                      [4],      [3],      [4],    [2],    [4],      [4],    [ 3],     [4],    [4]]
    assertTrue(randomizedCollection.insert(4));
    assertTrue(randomizedCollection.insert(3));
    assertFalse(randomizedCollection.insert(4));
    assertTrue(randomizedCollection.insert(2));
    assertFalse(randomizedCollection.insert(4));

    assertTrue(randomizedCollection.remove(4));
    assertTrue(randomizedCollection.remove(3));
    assertTrue(randomizedCollection.remove(4));
    assertTrue(randomizedCollection.remove(4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase2(RandomizedCollection randomizedCollection) {
    assertTrue(randomizedCollection.insert(0));
    assertTrue(randomizedCollection.insert(1));
    assertTrue(randomizedCollection.remove(0));
    assertTrue(randomizedCollection.insert(2));
    assertTrue(randomizedCollection.remove(1));
    assertEquals(2, randomizedCollection.getRandom());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase3(RandomizedCollection randomizedCollection) {
    assertTrue(randomizedCollection.insert(1));
    assertFalse(randomizedCollection.insert(1));
    assertTrue(randomizedCollection.insert(2));
    assertFalse(randomizedCollection.insert(1));
    assertFalse(randomizedCollection.insert(2));
    assertFalse(randomizedCollection.insert(2));
    assertTrue(randomizedCollection.remove(1));
    assertTrue(randomizedCollection.remove(2));
    assertTrue(randomizedCollection.remove(2));
    assertTrue(randomizedCollection.remove(2));
    assertEquals(1, randomizedCollection.getRandom());
    assertEquals(1, randomizedCollection.getRandom());
    assertEquals(1, randomizedCollection.getRandom());
    assertEquals(1, randomizedCollection.getRandom());
    assertEquals(1, randomizedCollection.getRandom());
    assertEquals(1, randomizedCollection.getRandom());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testFailedCase4(RandomizedCollection randomizedCollection) {
//["RandomizedCollection","insert","insert","insert","insert","insert","insert","remove","remove","remove","remove",
//[                     [],[10],    [10],     [20],   [20],     [30],   [30],   [10],     [10],     [30],   [30],
    assertTrue(randomizedCollection.insert(10));
    assertFalse(randomizedCollection.insert(10));
    assertTrue(randomizedCollection.insert(20));
    assertFalse(randomizedCollection.insert(20));
    assertTrue(randomizedCollection.insert(30));
    assertFalse(randomizedCollection.insert(30));
    assertTrue(randomizedCollection.remove(10));
    assertTrue(randomizedCollection.remove(10));
    assertTrue(randomizedCollection.remove(30));
    assertTrue(randomizedCollection.remove(30));
  }

  static Stream<RandomizedCollection> solutionProvider() {
    return Stream.of(
        new RandomizedCollectionI(),
        new RandomizedCollectionII(),
        new RandomizedCollectionIII()
    );
  }
}