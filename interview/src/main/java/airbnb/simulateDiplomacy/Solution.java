package airbnb.simulateDiplomacy;

import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public interface Solution {

  /**
   * @param actions 军队名 地点 1 action (地点 2／军队名)
   * @return Map, Army -> Location
   */
  Map<String, String> battle(final List<String> actions);
}
