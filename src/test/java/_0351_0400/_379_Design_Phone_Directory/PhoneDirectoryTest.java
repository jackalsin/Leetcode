package _0351_0400._379_Design_Phone_Directory;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PhoneDirectoryTest {

  @Test
  public void test3() throws Exception {
    final int NUM = 3;
    final PhoneDirectory phoneDirectory = new PhoneDirectory(NUM);

    for (int i = 0; i < NUM; i++) {
      assertTrue(phoneDirectory.check(i));
    }

    for (int i = 0; i < NUM; i++) {
      final int get = phoneDirectory.get();
      System.out.println(get);
      assertFalse(phoneDirectory.check(get));
    }

    for (int i = 0; i < NUM; i++) {
      phoneDirectory.release(i);
      System.out.println("Release " + i);
      assertTrue(phoneDirectory.check(i));
    }

  }
}