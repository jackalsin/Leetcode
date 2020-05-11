package interviews.google._1032_Stream_of_Characters;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<StreamChecker> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String[] input = new String[]{"cd", "f", "kl"};
    // init the dictionary.
    StreamChecker streamChecker = solutionClass.getConstructor(String[].class).newInstance(new Object[]{input});
    assertFalse(streamChecker.query('a'));          // return false
    assertFalse(streamChecker.query('b'));          // return false
    assertFalse(streamChecker.query('c'));          // return false
    assertTrue(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
    assertFalse(streamChecker.query('e'));          // return false
    assertTrue(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
    assertFalse(streamChecker.query('g'));          // return false
    assertFalse(streamChecker.query('h'));          // return false
    assertFalse(streamChecker.query('i'));          // return false
    assertFalse(streamChecker.query('j'));          // return false
    assertFalse(streamChecker.query('k'));          // return false
    assertTrue(streamChecker.query('l'));          // return true, because 'kl' is in the wordlist
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<StreamChecker> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final String[] input = new String[]{"abaa", "abaab", "aabbb", "bab", "ab"};
    // init the dictionary.
    StreamChecker streamChecker = solutionClass.getConstructor(String[].class).newInstance(new Object[]{input});
    assertFalse(streamChecker.query('a'));          // return false
    assertFalse(streamChecker.query('a'));          // return false
    assertTrue(streamChecker.query('b'));          // return true, because 'ab'
    assertFalse(streamChecker.query('b'));          // return false
    assertTrue(streamChecker.query('b'));          // return true, 'aabbb'
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        StreamCheckerI.class
    );
  }
}