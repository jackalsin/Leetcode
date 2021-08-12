package _0351_0400._388_Longest_Absolute_File_Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
    System.out.println("dir/subdir2/file.ext".length());

    assertEquals(20, solution.lengthLongestPath(path));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
    assertEquals(32, solution.lengthLongestPath(path));
  }

  @Test
  public void testAllFolder() throws Exception {
    assertEquals(0, solution.lengthLongestPath("a"));
  }

}
