package google.latestArrival;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
public interface Solution {
  /**
   * <a herf='https://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=753257&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311%26orderby%3Ddateline'/>
   * 1.有n辆shuttles,每辆有单独的capacity,还有m个人有他们的arrivals,问你最晚什么时候去等车能搭上shuttle
   *
   * @param shuttleArrivals
   * @param capacity
   * @param arrival
   * @return
   */
  int latestArrival(final int[] shuttleArrivals, final int[] capacity, final int[] arrival);
}
