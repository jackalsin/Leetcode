package _1001_1050._1032_Stream_of_Characters;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamCheckerTest {

  @Test
  void testOnlineCase1() {
    final String[] input = new String[]{"cd", "f", "kl"};
    StreamChecker streamChecker = new StreamChecker(input); // init the dictionary.
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
}