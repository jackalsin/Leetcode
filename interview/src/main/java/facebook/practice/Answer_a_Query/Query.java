package facebook.practice.Answer_a_Query;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
final class Query {
  public final int index, type;

  public Query(int type, int index) {
    this.index = index;
    this.type = type;
  }

  static Query of(int type, int index) {
    return new Query(type, index);
  }
}
