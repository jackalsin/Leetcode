package definition.nestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/6/2017.
 */
public final class NestedIntegerImpl implements NestedInteger {

  private final boolean isInteger;

  private final Integer val;

  private final List<NestedInteger> vals;

  public NestedIntegerImpl(int val) {
    isInteger = true;
    this.val = val;
    vals = null;
  }

  public NestedIntegerImpl(NestedInteger... vals) {
    isInteger = false;
    this.val = null;
    this.vals = List.of(vals);
  }

  @Override
  public boolean isInteger() {
    return isInteger;
  }

  @Override
  public Integer getInteger() {
    if (isInteger) {
      return val;
    }
    throw new IllegalStateException(this + " is not an Integer");
  }

  @Override
  public List<NestedInteger> getList() {
    if (isInteger) {
      throw new IllegalStateException(this + " is not a list");
    }
    return new ArrayList<>(vals);
  }

  @Override
  public String toString() {
    return "NestedIntegerImpl{" +
        "isInteger=" + isInteger +
        ", val=" + val +
        ", vals=" + vals +
        '}';
  }
}
