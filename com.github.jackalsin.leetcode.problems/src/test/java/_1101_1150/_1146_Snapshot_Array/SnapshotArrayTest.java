package _1101_1150._1146_Snapshot_Array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
class SnapshotArrayTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<Solution> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    Solution snapshotArr = cacheClass.getConstructor(Integer.TYPE).newInstance(3);
    snapshotArr.set(0, 5);  // Set array[0] = 5
    assertEquals(0, snapshotArr.snap());  // Take a snapshot, return snap_id = 0
    snapshotArr.set(0, 6);
    assertEquals(5, snapshotArr.get(0, 0));  // Get the value of array[0] with snap_id = 0, return 5
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SnapshotArray.class
    );
  }
}