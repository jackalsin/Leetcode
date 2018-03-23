package _751_800._772_Basic_Calculator_III.operator;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
public final class Subtraction implements BinaryOperator {

  @Override
  public double apply(double op1, double op2) {
    return op1 - op2;
  }

  @Override
  public String toString() {
    return "-";
  }
}
