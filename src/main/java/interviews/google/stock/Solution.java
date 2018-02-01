package interviews.google.stock;

/**
 * @author jacka
 * @version 1.0 on 1/30/2018.
 */
public class Solution {
  // TODO: Stock
  // www.1point3acres.com/bbs/thread-317551-1-1.html
  //   还问了个股票最高最低价钱的问题，给一堆股票的价钱，让算出每天的最高，最低，和当前价钱。实现add(day, price)，update(day, price)，remove
  // (day, price), get(day)。 我用了个stack + hashtable解了。有点像李口里面那个O(1)
  // 时间找stack的最小值的解法。stack里面是最大，最小，当前价钱，hashtable保存day->stack index. update就把后面的price都重算。remove
  // 重用 update的算法=update 成前一天的价钱。写code了


}
