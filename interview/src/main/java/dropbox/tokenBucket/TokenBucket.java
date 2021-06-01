package dropbox.tokenBucket;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/31/2021
 */
public interface TokenBucket extends Runnable {
  List<Integer> get(int n) throws InterruptedException;
}
