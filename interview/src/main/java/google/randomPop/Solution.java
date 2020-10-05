package google.randomPop;

/**
 * 能不能先有一个n size array， 然后pop第一个，在pop第二个，如果第二个小于第一个，说明第一个是原来sorted
 * list最大的那个就直接放在array最末尾，如果第二个大于第一个就把第一个放在第一位，如果相等就两个都先放着…继续pop直到不一样的东西出现，时间是O（n），space应该是O（1）吧
 *
 *  4. 一个奇怪的list，push的时候是push到头上，pop的时候按概率从头尾pop一个。问如果push了一个sorted
 * list进去，怎么pop一个sorted出来。二问如果pop是从头出来，而push是概率到头尾，怎么pop一个sorted。
 *
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public class Solution {

  public int[] randomPop(final RandomPopArray randomPopArray) {
    final int[] res = new int[randomPopArray.size()];
    int leftPtr = 0, rightPtr = res.length - 1, prev = -1, count = 0;
    if (randomPopArray.isEmpty()) {
      return res;
    }
    prev = randomPopArray.pop();
    count++;
    while (!randomPopArray.isEmpty()) {
      int cur = randomPopArray.pop();
      if (prev < cur) {
        while (count-- != 0) {
          res[leftPtr++] = prev;
        }
        prev = cur;
        count = 1;
      } else if (prev == cur) {
        count++;
      } else {
        while (count-- != 0) {
          res[rightPtr--] = prev;
        }
        prev = cur;
        count = 1;
      }
    }
    while (count-- != 0) {
      res[rightPtr--] = prev;
    }
    return res;
  }
}
