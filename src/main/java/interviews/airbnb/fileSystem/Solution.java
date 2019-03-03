package interviews.airbnb.fileSystem;

/**
 * @author jacka
 * @version 1.0 on 3/2/2019.
 */
public interface Solution {
  void create(String path, String value);

  boolean set_value(String path, String value);

  String get_value(String path);

  void watch(String path, Runnable runnable);

}
