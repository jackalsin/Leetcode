package _351_400._388_Longest_Absolute_File_Path;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class Solution {
  private int maxLength = 0;
  public int lengthLongestPath(String input) {
    final String[] inputs = input.split("\n");
    dfs(inputs, new ArrayDeque<>(), 0, 0);
    return maxLength;
  }

  private void dfs(final String[] inputs, final Deque<Integer> curPath, int curSize,
                   int curIndex) {
    if (curIndex != inputs.length) {
      final String curFileOrFolder = inputs[curIndex];
      int curLevel = getCurLevel(curFileOrFolder);
      while (curPath.size() > curLevel) {
        final int removedNameLen = curPath.removeLast();
        curSize -= removedNameLen;
      }
      final String name = curFileOrFolder.substring(curLevel);

      if (isDirectory(curFileOrFolder)) {
        curPath.addLast(name.length() + 1);
        dfs(inputs, curPath, curSize + name.length() + 1, curIndex + 1);
      } else {
        curPath.addLast(name.length());
        maxLength = Math.max(maxLength, curSize + name.length());
        dfs(inputs, curPath, curSize + name.length(), curIndex + 1);
      }
    }

  }

  private static int getCurLevel(String curFileOrFolder) {
    int i = 0;
    while (curFileOrFolder.charAt(i) == '\t') i++;
    return i;
  }

  private static boolean isDirectory(final String name) {
    return !name.contains(".");
  }
}
