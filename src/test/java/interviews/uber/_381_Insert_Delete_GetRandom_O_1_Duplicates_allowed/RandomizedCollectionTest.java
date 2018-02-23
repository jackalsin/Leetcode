package interviews.uber._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomizedCollectionTest {
  @Test
  void testFailedCase1() {
//    ["RandomizedCollection","insert","insert","insert","insert","insert","remove","remove","remove","remove"]
//    [[],                      [4],      [3],      [4],    [2],    [4],      [4],    [ 3],     [4],    [4]]
    final RandomizedCollection randomizedCollection = new RandomizedCollection();
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

  @Test
  void testFailedCase2() {
    final RandomizedCollection randomizedCollection = new RandomizedCollection();
    assertTrue(randomizedCollection.insert(0));
    assertTrue(randomizedCollection.insert(1));
    assertTrue(randomizedCollection.remove(0));
    assertTrue(randomizedCollection.insert(2));
    assertTrue(randomizedCollection.remove(1));
    assertEquals(2, randomizedCollection.getRandom());
  }

  @Test
  void testFailedCase3() {
    final RandomizedCollection randomizedCollection = new RandomizedCollection();
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
}