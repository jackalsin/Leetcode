package google.stringBuddies;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class Solution {
  /**
   * 第三轮，又一个白人小哥，上来先给了一个定义说两个string是buddies如果他们只有两个字母不一样且这两个字母交换后就可以变成一样的，比如converse和conserve
   * 这样，然后让写一个func判断两个string是不是buddies，楼主就给了一个O(n)
   * 的算法，写完之后小哥又问我要测我的代码的话我会选哪些testcase，感觉谷歌对这方面好像很热衷啊，要不我这就也是巧了，然后我就大概说了下都有哪些不同类型的case
   * 要考虑，然后一看时间又剩好多，估计又要被问其他题，这次在听到小哥说我写的很快时就不敢放松了，感觉这简直是谷歌的套路，然后就来了一个类似上一题的延展那样子的，就是说有n
   * 个字母不一样且交换完能相同的就叫nth buddies，然后让我写一个int func判断两个string是？th
   * buddies，比如listen和slient
   * 这种，然后我一开始因为想看看能不能有个既省时间又省空间的算法，就又沉默了一分钟，然后这个小哥就也主动问我有没有什么想法了，感觉谷歌真的很注重交流，然后没办法我就把我最开始想到的一个O
   * (n)的算法给说了，后来也写了代码，看小哥也没有再问我优化的样子，我也就没再想了
   */
  public boolean isBuddies(String a, String b) {
    final Map<Character, Set<Integer>> aCharToIndexMap = new HashMap<>();
    char[] aCharArray = a.toCharArray();
    for (int i = 0; i < aCharArray.length; i++) {
      char chr = aCharArray[i];
      aCharToIndexMap.put(chr, new HashSet<>());
      aCharToIndexMap.get(chr).add(i);
    }
    final char[] bCharArray = b.toCharArray();
    for (int i = 0; i < bCharArray.length; i++) {
      char chr = bCharArray[i];
      if (aCharToIndexMap.containsKey(chr)) {
        final Set<Integer> aCharIndexSet = aCharToIndexMap.get(chr);
        aCharIndexSet.remove(i);
        if (aCharIndexSet.isEmpty()) {
          aCharToIndexMap.remove(chr);
        }
      } else {
        return false;
      }
    }
    if (aCharToIndexMap.size() != 2) {
      return false;
    }
    for (Map.Entry<Character, Set<Integer>> entry : aCharToIndexMap.entrySet()) {
      if (entry.getValue().size() != 1) {
        return false;
      }
    }
    return true;
  }
}
