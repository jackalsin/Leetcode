package interviews.linkedin._460_LFU_Cache;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/13/18
 */
public interface LFUCache {

  int get(int key);

  void put(int key, int value);
}
